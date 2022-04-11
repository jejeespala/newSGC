import { Component, OnInit } from '@angular/core';
import {TurmaService} from "../../service/turma.service";
import {DynamicDialogConfig, SelectItem} from 'primeng';
import {ColaboradorService} from "../../../colaborador/service/colaborador.service";
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-turma-form',
  templateUrl: './turma-form.component.html',
  styleUrls: ['./turma-form.component.css']
})
export class TurmaFormComponent implements OnInit {

    status: SelectItem[];
    competencias: SelectItem[];
    colaboradores: SelectItem[];
    formColComp: FormGroup;

  constructor(private turmaService: TurmaService, private colaboradorService: ColaboradorService, private fb: FormBuilder,
              private config: DynamicDialogConfig) { }

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
              id_colaborador: [null],
              id_competencia: [null]
          }
      )


  }

  listaStatus() {

      this.turmaService.buscarStatus().subscribe( resposta =>{
          this.status = resposta;
      })

  }

  listarCompetencias() {

      this.colaboradorService.buscarCompetencia().subscribe(resposta => {

          this.competencias = resposta;
      })

      if(this.config.data !== undefined) {

          this.formColComp.patchValue(this.config.data);
          this.formColComp.patchValue({data_inicio: new Date(this.config.data.data_inicio),
              data_termino: new Date(this.config.data.data_termino)})
      }
  }

  listarColaborador(id: number) {

      if(id) {

          this.colaboradorService.buscarColaboradorNivelMaximo(id).subscribe( resposta => {

              this.colaboradores = resposta;

          })

      }


  }



}
