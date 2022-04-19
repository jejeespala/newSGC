import { Component, OnInit } from '@angular/core';
import {CompetenciaService} from '../../service/competencia.service';
import {CompetenciaModel} from '../../models/competencia.model';
import {CategoriaModel} from '../../models/categoria.model';
import {DialogService} from 'primeng/dynamicdialog';
import {FormComponent} from '../form/form.component';
import {PageNotificationService} from "@nuvem/primeng-components";
import {CompetenciaFormModel} from '../../models/competencia-form.model';
import { BlockUI, NgBlockUI } from 'ng-block-ui';
import {catchError, finalize, take} from 'rxjs/operators';
import {of} from 'rxjs';

@Component({
  selector: 'app-competencia-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

    competencias: CompetenciaModel[];
    categorias: CategoriaModel [];
    competencia: CompetenciaFormModel;
    @BlockUI() blockUI: NgBlockUI;

    constructor(private competenciasService: CompetenciaService, private dialogService: DialogService,
                private messageService: PageNotificationService) { }

  ngOnInit(): void {
      this.listar();
      this.listarCategorias();
  }

  listar() {
      this.blockUI.start("Por favor, aguarde!");
      this.competenciasService.buscar().pipe(
            catchError(err => of([])),
            finalize(() => this.blockUI.stop())
        ).subscribe(resposta => {
            this.competencias = resposta;
        },
        error => this.messageService.addErrorMessage("Não foi possível realizar a listagram"))
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
                        this.listar()
                    },
                    error: error => {
                        this.messageService.addErrorMessage('Não foi possível deletar a competência')
                    }
                }
            )
    }

}
