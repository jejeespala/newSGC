import { Component, OnInit } from '@angular/core';
import {TurmaModel} from "../../models/turma.model";
import {TurmaService} from "../../service/turma.service";
import {DialogService} from "primeng/dynamicdialog";
import {FormComponent} from "../form/form.component";
import {PageNotificationService} from '@nuvem/primeng-components';
import {TurmaColaboradorCompetenciaModel} from '../../models/colaborador-competencia.model';

@Component({
  selector: 'app-turma-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

    turmas: TurmaModel[];
    turma: TurmaModel;
    colsComps: TurmaColaboradorCompetenciaModel[];

    constructor(private turmaService: TurmaService, private dialogService: DialogService, private messageService: PageNotificationService) { }

  ngOnInit(): void {
        this.listarTurma();
  }

    listarTurma() {
        this.turmaService.buscar().subscribe(resposta => {
            this.turmas = resposta;
        });
    }

    show() {
        const ref = this.dialogService.open(FormComponent, {
            header: 'Cadastrar Turma',
            width: '70%',
            contentStyle: {'overflow': 'auto'}
        });
    }

    showOne(id) {
        this.turmaService.buscarId(id).subscribe( resposta => {
            this.turmaService.buscarColaboradorId(id).subscribe( resposta2 => {
                this.turma = resposta;
                this.colsComps = resposta2;
            })

            const ref = this.dialogService.open(FormComponent, {
                data: {turma: this.turma,
                colsComps: this.colsComps},
                width: '70%',
                header: 'Colaborador'
            });
        })
    }

    onDelete(id){
        this.turmaService.deletar(id)
            .subscribe({
                    next: data => {
                        this.listarTurma()
                        this.messageService.addSuccessMessage("Turma excluída com sucesso")
                    },
                    error: error => {
                        this.messageService.addErrorMessage('Não foi possível deletar a turma')
                    }
                }
            )
    }

}
