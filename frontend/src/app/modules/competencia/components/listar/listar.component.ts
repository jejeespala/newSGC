import { Component, OnInit } from '@angular/core';
import {CompetenciaService} from '../../service/competencia.service';
import {CompetenciaModel} from '../../models/competencia.model';
import {CategoriaModel} from '../../models/categoria.model';
import {DialogService} from 'primeng/dynamicdialog';
import {FormComponent} from '../form/form.component';
import {DynamicDialogRef, MessageService} from 'primeng';
import {PageNotificationService} from "@nuvem/primeng-components";

@Component({
  selector: 'app-competencia-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

    competencias: CompetenciaModel[];
    categorias: CategoriaModel [];
    competencia: CompetenciaModel;

  constructor(private competenciasService: CompetenciaService, private dialogService: DialogService, private messageService: PageNotificationService,
              private ref: DynamicDialogRef) { }

  ngOnInit(): void {
      this.listarCompetencias();
      this.listarCategorias();
  }

  listarCompetencias() {
      this.competenciasService.buscar().subscribe(resposta => {
          this.competencias = resposta;
      });
  }

  listarCategorias() {
      this.competenciasService.buscarCategoria().subscribe( resposta => {
          this.categorias = resposta;

      });
  }

    show() {
        const ref = this.dialogService.open(FormComponent, {
            header: 'Competência',
            width: '35%',
            height: '75%'
        });
    }

    showOne(id) {
      this.competenciasService.buscarId(id).subscribe( resposta => {
          this.competencia = resposta;
          const ref = this.dialogService.open(FormComponent, {
              data: this.competencia,
              header: 'Competência',
              width: '35%',
              height: '75%'
          });
      })
    }

    onDelete(id){
        this.competenciasService.deletar(id)
            .subscribe({
                    next: data => {
                        this.messageService.addSuccessMessage("Competência excluída com sucesso")
                        this.listarCompetencias()
                    },
                    error: error => {
                        this.messageService.addErrorMessage('Não foi possível deletar a competência')
                    }
                }
            )
    }

}
