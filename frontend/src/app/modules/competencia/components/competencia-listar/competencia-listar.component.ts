import { Component, OnInit } from '@angular/core';
import {CompetenciaService} from '../../service/competencia.service';
import {CompetenciaModel} from '../../models/competencia.model';
import {CategoriaModel} from '../../models/categoria.model';
import {DialogService} from 'primeng/dynamicdialog';
import {CompetenciaFormComponent} from '../competencia-form/competencia-form.component';

@Component({
  selector: 'app-competencia-listar',
  templateUrl: './competencia-listar.component.html',
  styleUrls: ['./competencia-listar.component.css']
})
export class CompetenciaListarComponent implements OnInit {

    competencias: CompetenciaModel[];
    categorias: CategoriaModel [];
    competencia: CompetenciaModel;

  constructor(private competenciasService: CompetenciaService, private dialogService: DialogService) { }

  ngOnInit(): void {

      this.listarCompetencias();
      this.listarCategorias();
  }

  listarCompetencias() {

      this.competenciasService.buscarCompetencia().subscribe(resposta => {
          this.competencias = resposta;
      });

  }

  listarCategorias() {

      this.competenciasService.buscarCategoria().subscribe( resposta => {
          this.categorias = resposta;

      });
  }

    show() {
        const ref = this.dialogService.open(CompetenciaFormComponent, {
            header: 'Competência',
            width: '35%',
            height: '75%'
        });
    }

    showOne(id) {



      this.competenciasService.buscarCompetenciaId(id).subscribe( resposta => {
          this.competencia = resposta;
      })
        const ref = this.dialogService.open(CompetenciaFormComponent, {
            data: this.competencia,
            header: 'Competência',
            width: '35%',
            height: '75%'
        });

    }

}
