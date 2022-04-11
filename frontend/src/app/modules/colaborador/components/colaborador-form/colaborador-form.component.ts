import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DynamicDialogConfig, SelectItem} from 'primeng';
import {ColaboradorService} from '../../service/colaborador.service';
import {PageNotificationService} from '@nuvem/primeng-components';
import {CompetenciaService} from "../../../competencia/service/competencia.service";
import {DatePipe} from "@angular/common";
import {config} from "rxjs";

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './colaborador-form.component.html',
  styleUrls: ['./colaborador-form.component.css']
})
export class ColaboradorFormComponent implements OnInit {

    formCol: FormGroup;
    competencias: FormGroup;


  constructor(private colaboradorService: ColaboradorService, private fb: FormBuilder, private messageService: PageNotificationService,
              private competenciaService: CompetenciaService, private config: DynamicDialogConfig, private datepipe: DatePipe ) { }

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

      if(this.config.data !== undefined) {

          console.log(this.config.data.colaborador)
          console.log(this.config.data.colaboradorCompetencia)
          this.formCol.patchValue(this.config.data.colaborador);
          this.formCol.patchValue({data_nasc: new Date(this.config.data.colaborador.data_nasc),
                                        data_admi: new Date(this.config.data.colaborador.data_admi)})


      }
  }

  salvarColaborador() {

        if (this.formCol.valid) {
          this.colaboradorService.salvarColaborador(this.formCol.value).subscribe(
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
      console.log(this.formCol.value)
  }

  buscarCompetencia(id) {

      console.log("entrou")
      this.competenciaService.buscarCompetenciaId(id).subscribe( resposta => {

          return resposta;
      })
  }




}
