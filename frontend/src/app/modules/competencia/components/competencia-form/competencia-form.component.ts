import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DynamicDialogConfig, DynamicDialogRef, MessageService, SelectItem} from 'primeng';
import {CompetenciaService} from '../../service/competencia.service';
import {success} from 'ng-packagr/lib/utils/log';
import {PageNotificationService} from '@nuvem/primeng-components';
import {config} from "rxjs";

@Component({
  selector: 'app-competencia-form',
  templateUrl: './competencia-form.component.html',
  styleUrls: ['./competencia-form.component.css']
})
export class CompetenciaFormComponent implements OnInit {

    categorias: SelectItem[];
    form: FormGroup;


  constructor(private fb: FormBuilder, private competenciaService: CompetenciaService, private messageService: PageNotificationService,
              private config: DynamicDialogConfig, private ref: DynamicDialogRef ) { }

  ngOnInit(): void {

      this.novoFormulario();
      this.listarCategoria();
  }

  novoFormulario() {

      this.form = this.fb.group({
          id: [null],
          nome: [null, [Validators.required, Validators.minLength(3)]],
          descricao: [null, [Validators.required, Validators.minLength(3)]],
          id_categoria: [null, [Validators.required]]
      });

  }

  listarCategoria() {
      this.competenciaService.buscarCategoria().subscribe(resposta => {
          this.categorias = resposta;

          if(this.config.data !== undefined) {
              this.form.patchValue(this.config.data);
          }
      });
  }

  onSubmit() {

      if (this.form.valid) {
          this.competenciaService.salvarCompetencia(this.form.value).subscribe(
              succcess => this.ref.close(this.messageService.addSuccessMessage('Salvo com sucesso', 'Competência')),
              error => this.messageService.addErrorMessage('Não foi possível salvar!', 'Competência')
          );


      }
  }


}
