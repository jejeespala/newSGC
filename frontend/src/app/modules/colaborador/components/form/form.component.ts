import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DynamicDialogConfig, SelectItem} from 'primeng';
import {ColaboradorService} from '../../service/colaborador.service';
import {PageNotificationService} from '@nuvem/primeng-components';
import {CompetenciaService} from "../../../competencia/service/competencia.service";

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

    formCol: FormGroup;
    competencias: FormGroup;


  constructor(private colaboradorService: ColaboradorService, private fb: FormBuilder, private messageService: PageNotificationService,
              private competenciaService: CompetenciaService, private config: DynamicDialogConfig ) { }

  ngOnInit(): void {
      this.novoFormularioColaborador();
  }

  novoFormularioColaborador() {
    this.formCol = this.fb.group( {
        id: [null],
        nome: [null, [Validators.required, Validators.minLength(3)]],
        sobrenome: [null, [Validators.required, Validators.minLength(3)]],
        cpf: [null, [Validators.required]],
        email: [null, [Validators.required, Validators.minLength(3)]],
        data_nasc: [null, [Validators.required]],
        data_admi: [null, [Validators.required]],
        id_senioridade: [null, [Validators.required]],
        competencias: [[]]
    });

      if(this.config.data) {
          this.formCol.patchValue(this.config.data.colaborador);
          this.formCol.patchValue({data_nasc: new Date(this.config.data.colaborador.data_nasc),
                                        data_admi: new Date(this.config.data.colaborador.data_admi),
                                        competencias: this.config.data.colaboradorCompetencia})
      }
  }

  salvarColaborador() {
        if (this.formCol.valid) {
          this.colaboradorService.salvar(this.formCol.value).subscribe(
              success => this.messageService.addSuccessMessage('Colaborador salvo com sucesso!'),
              error => this.messageService.addErrorMessage('Não foi possível realizar o cadastro do colaborador')
          );
      }
  }

  adicionarCompetencia (competencia) {
      if( this.formCol.get('competencias').value.some(cc => cc.id_competencia == competencia.id_competencia)){
          this.messageService.addErrorMessage('Competência já inserida')
      }else{
          this.formCol.get('competencias').value.push(competencia);
      }
  }

  deletarCompetencia(competencia) {
      this.formCol.get('competencias').value.pop(competencia);
  }

}
