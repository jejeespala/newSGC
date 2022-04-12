import { Component, OnInit } from '@angular/core';
import {TurmaService} from "../../service/turma.service";
import {DynamicDialogConfig, DynamicDialogRef, SelectItem} from 'primeng';
import {ColaboradorService} from "../../../colaborador/service/colaborador.service";
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CompetenciaService} from '../../../competencia/service/competencia.service';
import {PageNotificationService} from '@nuvem/primeng-components';
import {ColaboradorCompetenciaModel} from '../../models/colaborador-competencia.model';

@Component({
  selector: 'app-turma-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

    status: SelectItem[];
    competencias: SelectItem[];
    colaboradores: SelectItem[];
    formColComp: FormGroup;
    colaboradorCompetencia: FormArray;
    colComp: FormGroup;

  constructor(private turmaService: TurmaService, private colaboradorService: ColaboradorService, private fb: FormBuilder,
              private config: DynamicDialogConfig, private competenciaService: CompetenciaService,
              private messageService: PageNotificationService, private ref: DynamicDialogRef) { }

  ngOnInit(): void {
      this.novoFormularioColaboradorCompetencia();
      this.listaStatus();
      this.listarCompetencias();
  }

  novoFormularioColaboradorCompetencia() {
      this.formColComp = this.fb.group(
          {
              nome: [null, [Validators.required]],
              descricao: [null, [Validators.required]],
              data_inicio: [null,[Validators.required]],
              data_termino: [null, [Validators.required]],
              id_status: [null, [Validators.required]],
              colaboradorCompetencia: this.fb.array([])
          }
      )
  }

  listaStatus() {
      this.turmaService.buscarStatus().subscribe( resposta =>{
          this.status = resposta;
      })
  }

  listarCompetencias() {

      this.competenciaService.buscarDropdown().subscribe(resposta => {
          this.competencias = resposta;
      })

      if(this.config.data) {
          this.formColComp.patchValue(this.config.data);
          this.formColComp.patchValue({data_inicio: new Date(this.config.data.data_inicio),
              data_termino: new Date(this.config.data.data_termino)})
      }
  }

  listarColaborador(id) {
      if(id) {
          this.colaboradorService.buscarNivelMaximo(id).subscribe( resposta => {
              this.colaboradores = resposta;
          })
      }
  }

    salvar() {
        if (this.formColComp.valid) {
            console.log(this.formColComp.value)
            // this.competenciaService.salvar(this.formColComp.value).subscribe(
            //     succcess => this.ref.close(this.messageService.addSuccessMessage('Salvo com sucesso', 'Turma')),
            //     error => this.messageService.addErrorMessage('Não foi possível salvar!', 'Turma')
            // );
        }
    }

    // adicionarColaboradorCompetencia(colaboradorCompetencia) {
    //     this.formColComp.get('colaboradorCompetencia').value.push(colaboradorCompetencia);
    //
    //
    // }

    pegarColaboradoresCompetencias() {
      return this.formColComp.controls["colaboradorCompetencia"] as FormArray;
    }

    adicionarColaboradorCompetencia() {

          const colComp = this.fb.group({
              id_turma: [null],
              id_colaborador: [null],
              id_competencia: [null]
          })

        this.colaboradorCompetencia.push(colComp);
    }
}
