import { ColaboradorService } from './../../service/colaborador.service';
import { ColaboradorModel } from './../../models/colaborador.model';
import { Component, OnInit } from '@angular/core';
import {CompetenciaFormComponent} from '../../../competencia/components/competencia-form/competencia-form.component';
import {Dialog} from 'primeng';
import {DialogService} from 'primeng/dynamicdialog';
import {ColaboradorFormComponent} from '../colaborador-form/colaborador-form.component';

@Component({
  selector: 'app-colaborador-listar',
  templateUrl: './colaborador-listar.component.html',
  styleUrls: ['./colaborador-listar.component.css']
})
export class ColaboradorListarComponent implements OnInit {

  colaboradores : ColaboradorModel[]


  constructor(private colaboradorService: ColaboradorService, private dialogService: DialogService) { }

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
            width: '70%'
        });
    }

}
