import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SelectItem} from 'primeng';
import {ColaboradorService} from '../../service/colaborador.service';
import {PageNotificationService} from '@nuvem/primeng-components';
import {ColaboradorCompetenciaModel} from '../../models/colaborador-competencia.model';

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './colaborador-form.component.html',
  styleUrls: ['./colaborador-form.component.css']
})
export class ColaboradorFormComponent implements OnInit {

    formCol: FormGroup;
    competencias: FormGroup;
    competencia: SelectItem[];
    nivel: SelectItem[];

  constructor(private colaboradorService: ColaboradorService, private fb: FormBuilder, private messageService: PageNotificationService) { }

  ngOnInit(): void {

      this.novoFormularioColaborador();
      this.listarCompetencias();
      this.listarNiveis();
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



  listarCompetencias() {
      this.colaboradorService.buscarCompetencia().subscribe(
          resposta => {
              this.competencia = resposta;
          });
  }

  listarNiveis() {
      this.nivel = this.colaboradorService.buscarNivel();
  }

  salvarColaborador() {

      console.log('entrou');
      console.log(this.formCol.value);
      // if (this.formCol.valid) {
      //     this.colaboradorService.salvarColaborador(this.formCol.value).subscribe(
      //         success => this.messageService.addSuccessMessage('Colaborador salvo com sucesso!'),
      //         error => this.messageService.addErrorMessage('Não foi possível realizar o cadastro do colaborador')
      //     );
      // }
  }

  adicionarCompetencia (competencia: ColaboradorCompetenciaModel) {

      this.formCol.get('competencias').value.push(competencia);

  }


}
