import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SelectItem} from 'primeng';
import {ColaboradorService} from '../../service/colaborador.service';
import {PageNotificationService} from '@nuvem/primeng-components';
import {ColaboradorCompetenciaModel} from '../../models/colaborador-competencia.model';
import {CompetenciaService} from "../../../competencia/service/competencia.service";

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './colaborador-form.component.html',
  styleUrls: ['./colaborador-form.component.css']
})
export class ColaboradorFormComponent implements OnInit {

    formCol: FormGroup;
    competencias: FormGroup;


  constructor(private colaboradorService: ColaboradorService, private fb: FormBuilder, private messageService: PageNotificationService,
              private competenciaService: CompetenciaService) { }

  ngOnInit(): void {

      this.novoFormularioColaborador();

  }

  novoFormularioColaborador() {
    this.formCol = this.fb.group( {
        id: [null],
        nome: [null, [Validators.required, Validators.minLength(3)]],
        sobrenome: [null, [Validators.required, Validators.minLength(3)]],
        cpf: [null, [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
        email: [null, [Validators.required, Validators.minLength(3)]],
        data_nasc: [null, [Validators.required]],
        data_admi: [null, [Validators.required]],
        id_senioridade: [null, [Validators.required]],
        competencias: [[], [Validators.required]]
    });
  }


  salvarColaborador() {

      console.log('entrou');
      // console.log(this.formCol.value);
      // if (this.formCol.valid) {
      //     this.colaboradorService.salvarColaborador(this.formCol.value).subscribe(
      //         success => this.messageService.addSuccessMessage('Colaborador salvo com sucesso!'),
      //         error => this.messageService.addErrorMessage('Não foi possível realizar o cadastro do colaborador')
      //     );
      // }
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
