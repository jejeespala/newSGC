import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DynamicDialogConfig, SelectItem} from 'primeng';
import {ColaboradorService} from '../../service/colaborador.service';
import {PageNotificationService} from '@nuvem/primeng-components';
import {CompetenciaService} from "../../../competencia/service/competencia.service";
import {CompetenciaDropdownModel} from '../../models/competencia.model';
import {ColaboradorCompetenciaNivelModel} from '../../models/colaborador-competencia-nivel.model';
import {CompetenciaModel} from '../../../competencia/models/competencia.model';

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

    uploadedFiles: any[] = [];
    formCol: FormGroup;
    competencias: FormGroup;
    senioridades: SelectItem[];
    comp: CompetenciaDropdownModel[];
    comps: ColaboradorCompetenciaNivelModel[];


  constructor(private colaboradorService: ColaboradorService, private fb: FormBuilder, private messageService: PageNotificationService,
              private competenciaService: CompetenciaService, private config: DynamicDialogConfig ) { }

  ngOnInit(): void {
      this.listarCompetencias();
      this.novoFormularioColaborador();
      this.buscarSenioridade();
  }

  novoFormularioColaborador() {

    this.formCol = this.fb.group( {
        id: [null],
        nome: [null, [Validators.required, Validators.minLength(3)]],
        sobrenome: [null, [Validators.required, Validators.minLength(3)]],
        // foto: [null],
        cpf: [null, [Validators.required]],
        email: [null, [Validators.required, Validators.minLength(3)]],
        data_nasc: [null, [Validators.required]],
        data_admi: [null, [Validators.required]],
        idSenioridade: [null, [Validators.required]],
        competencias: [[]]
    });

    if(this.config.data) {
        this.atualizar(this.config.data);
    }

  }

  salvarColaborador() {
      console.log(this.config.data)
      //   if (this.formCol.valid) {
      //     this.colaboradorService.salvar(this.formCol.value).subscribe(
      //         success => this.messageService.addSuccessMessage('Colaborador salvo com sucesso!'),
      //         error => this.messageService.addErrorMessage('Não foi possível realizar o cadastro do colaborador')
      //     );
      // }
  }

  atualizar(colaborador) {

      let dataNascimento = new Date(colaborador.colaborador.data_nasc);
      let dataAdmissao = new Date(colaborador.colaborador.data_admi);

      colaborador.colaborador.data_nasc = dataNascimento;
      colaborador.colaborador.data_admi = dataAdmissao;

      this.formCol.patchValue(colaborador.colaborador);

      if(colaborador.colaboraCompetencia){
          this.comps = colaborador.colaboraCompetencia;
          this.formCol.get('competencias').patchValue(colaborador.colaboraCompetencia);
          console.log(this.formCol.value);
      }
  }

  adicionarCompetencia (competencia) {
      if( this.formCol.get('competencias').value.some(cc => cc.idCompetencia == competencia.idCompetencia)){
          this.messageService.addErrorMessage('Competência já inserida')
      }else{
          this.formCol.get('competencias').value.push(competencia);
      }
  }

  deletarCompetencia(competencia) {

      this.formCol.controls[competencia].patchValue(null);
  }

  buscarSenioridade() {
      this.colaboradorService.buscarSenioridade().subscribe( resposta => {
          this.senioridades = resposta;
      })
  }

    onUpload(event) {
        console.log("entrou");
        for(let file of event.files) {
            this.uploadedFiles.push(file);
        }

        // this.formCol.patchValue({
        //     foto:
        // })
    }

    listarCompetencias() {
        this.competenciaService.buscarDropdown().subscribe(
            resposta => {
                this.comp = resposta;
            });
    }
}
