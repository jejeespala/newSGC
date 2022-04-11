import { ColaboradorService } from './../../service/colaborador.service';
import { ColaboradorModel } from './../../models/colaborador.model';
import { Component, OnInit } from '@angular/core';
import {CompetenciaFormComponent} from '../../../competencia/components/competencia-form/competencia-form.component';
import {Dialog} from 'primeng';
import {DialogService} from 'primeng/dynamicdialog';
import {ColaboradorFormComponent} from '../colaborador-form/colaborador-form.component';
import {ColaboradorPostModel} from "../../models/colaboradorPost.model";
import {ColaboradorCompetenciaModel} from "../../models/colaborador-competencia.model";
import {PageNotificationService} from "@nuvem/primeng-components";

@Component({
  selector: 'app-colaborador-listar',
  templateUrl: './colaborador-listar.component.html',
  styleUrls: ['./colaborador-listar.component.css']
})
export class ColaboradorListarComponent implements OnInit {

  colaboradores: ColaboradorModel[];
  colaborador: ColaboradorPostModel;
  colaboradorCompetencia: ColaboradorCompetenciaModel[];


  constructor(private colaboradorService: ColaboradorService, private dialogService: DialogService, private messageService: PageNotificationService) { }

  ngOnInit(): void {

    this.listarColaboradores();
  }

  listarColaboradores() {

    this.colaboradorService.buscarColaborador().subscribe(resposta => {
      this.colaboradores = resposta;
    });

  }

    show() {
        const ref = this.dialogService.open(ColaboradorFormComponent, {
            header: 'Cadastrar Colaborador',
            width: '70%',
            contentStyle: {'overflow': 'auto'}
        });
    }

    showOne(id) {

        this.colaboradorService.buscarColaboradorId(id).subscribe( resposta => {
            this.colaborador = resposta;
            console.log(resposta)
            this.colaboradorService.buscarColaboradorCompetenciaId(id).subscribe( resposta => {

                this.colaboradorCompetencia = resposta;
            })

            const ref = this.dialogService.open(ColaboradorFormComponent, {
                data: {colaborador: this.colaborador,
                colaboraCompetencia: this.colaboradorCompetencia},
                width: '70%',
                header: 'Colaborador'
            });
        })

    }

    onDelete(id){

        this.colaboradorService.deletar(id)
            .subscribe({
                    next: data => {
                        this.listarColaboradores()
                    },
                    error: error => {
                        this.messageService.addErrorMessage('Não foi possível deletar a competência')
                    }
                }

            )

    }

}
