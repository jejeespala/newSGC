import { Component, OnInit } from '@angular/core';
import {TurmaModel} from "../../models/turma.model";
import {TurmaService} from "../../service/turma.service";
import {ColaboradorFormComponent} from "../../../colaborador/components/colaborador-form/colaborador-form.component";
import {DialogService} from "primeng/dynamicdialog";
import {TurmaFormComponent} from "../turma-form/turma-form.component";
import {PageNotificationService} from '@nuvem/primeng-components';

@Component({
  selector: 'app-turma-listar',
  templateUrl: './turma-listar.component.html',
  styleUrls: ['./turma-listar.component.css']
})
export class TurmaListarComponent implements OnInit {

    turmas: TurmaModel[];
    turma: TurmaModel;

    constructor(private turmaService: TurmaService, private dialogService: DialogService, private messageService: PageNotificationService) { }

  ngOnInit(): void {
        this.listarTurma();
  }

    listarTurma() {
        this.turmaService.buscarTurma().subscribe(resposta => {

            this.turmas = resposta;
        });
    }

    show() {
        const ref = this.dialogService.open(TurmaFormComponent, {
            header: 'Cadastrar Turma',
            width: '70%',
            contentStyle: {'overflow': 'auto'}
        });
    }

    showOne(id) {

        this.turmaService.buscarTurmaId(id).subscribe( resposta => {
            this.turma = resposta;


            const ref = this.dialogService.open(TurmaFormComponent, {
                data: this.turma,
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
