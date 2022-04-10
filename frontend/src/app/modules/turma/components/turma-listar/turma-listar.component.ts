import { Component, OnInit } from '@angular/core';
import {TurmaModel} from "../../models/turma.model";
import {TurmaService} from "../../service/turma.service";
import {ColaboradorFormComponent} from "../../../colaborador/components/colaborador-form/colaborador-form.component";
import {DialogService} from "primeng/dynamicdialog";
import {TurmaFormComponent} from "../turma-form/turma-form.component";

@Component({
  selector: 'app-turma-listar',
  templateUrl: './turma-listar.component.html',
  styleUrls: ['./turma-listar.component.css']
})
export class TurmaListarComponent implements OnInit {

    turmas: TurmaModel[];

    constructor(private turmaService: TurmaService, private dialogService: DialogService) { }

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


}
