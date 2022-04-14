import { ColaboradorService } from './../../service/colaborador.service';
import { ColaboradorModel } from './../../models/colaborador.model';
import { Component, OnInit } from '@angular/core';
import {DialogService} from 'primeng/dynamicdialog';
import {FormComponent} from '../form/form.component';
import {ColaboradorPostModel} from "../../models/colaboradorPost.model";
import {ColaboradorCompetenciaNivelModel} from "../../models/colaborador-competencia-nivel.model";
import {PageNotificationService} from "@nuvem/primeng-components";

@Component({
  selector: 'app-colaborador-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  colaboradores: ColaboradorModel[];
  colaborador: ColaboradorPostModel;
  colaboradorCompetencia: ColaboradorCompetenciaNivelModel[];

  constructor(private colaboradorService: ColaboradorService, private dialogService: DialogService, private messageService: PageNotificationService) { }

  ngOnInit(): void {
    this.listarColaboradores();
  }

  listarColaboradores() {
    this.colaboradorService.buscar().subscribe(resposta => {
      this.colaboradores = resposta;
    });
  }

    show() {
        const ref = this.dialogService.open(FormComponent, {
            header: 'Cadastrar Colaborador',
            width: '70%',
            contentStyle: {'overflow': 'auto'}
        });
    }

    showOne(id) {
        this.colaboradorService.buscarId(id).subscribe( resposta => {
            this.colaboradorService.buscarCompetenciaId(id).subscribe( resposta2 => {
                this.colaborador = resposta
                this.colaboradorCompetencia = resposta2
                const ref = this.dialogService.open(FormComponent, {
                    data: {colaboraCompetencia: this.colaboradorCompetencia,
                        colaborador: this.colaborador},
                    width: '70%',
                    header: 'Colaborador'
                });
            })
        })
    }

    onDelete(id){
        this.colaboradorService.deletar(id)
            .subscribe({
                    next: data => {
                        this.listarColaboradores()
                    },
                    error: error => {
                        this.messageService.addErrorMessage('Não foi possível deletar o colaborador')
                    }
                }
            )
    }

}
