import { Component, OnInit } from '@angular/core';
import {TurmaService} from "../../service/turma.service";
import {SelectItem} from "primeng";
import {ColaboradorService} from "../../../colaborador/service/colaborador.service";
import {FormBuilder, FormGroup} from "@angular/forms";

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

  constructor(private turmaService: TurmaService, private colaboradorService: ColaboradorService, private fb: FormBuilder) { }

  ngOnInit(): void {

      this.novoFormularioColaboradorCompetencia();
      this.listaStatus();
      this.listarCompetencias();
  }

  novoFormularioColaboradorCompetencia() {

      this.formColComp = this.fb.group(
          {
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
  }

  listarColaborador(id: number) {

      if(id) {

          this.colaboradorService.buscarColaboradorNivelMaximo(id).subscribe( resposta => {

              this.colaboradores = resposta;

          })

      }


  }



}
