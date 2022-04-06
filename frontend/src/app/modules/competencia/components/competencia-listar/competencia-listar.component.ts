import { Component, OnInit } from '@angular/core';
import {CompetenciaService} from '../../service/competencia.service';
import {CompetenciaModel} from '../../models/competencia.model';
import {BlockUIService} from 'ng-block-ui';
import {CategoriaModel} from '../../models/categoria.model';

@Component({
  selector: 'app-competencia-listar',
  templateUrl: './competencia-listar.component.html',
  styleUrls: ['./competencia-listar.component.css']
})
export class CompetenciaListarComponent implements OnInit {

    competencias: CompetenciaModel[];
    categorias: CategoriaModel [];

  constructor(private competenciasService: CompetenciaService) { }

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

}
