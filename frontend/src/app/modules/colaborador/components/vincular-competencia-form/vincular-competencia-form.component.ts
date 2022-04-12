import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ColaboradorCompetenciaModel} from '../../models/colaborador-competencia.model';
import {ColaboradorService} from "../../service/colaborador.service";
import {SelectItem} from 'primeng';
import {CompetenciaService} from '../../../competencia/service/competencia.service';
import {CompetenciaModel} from '../../../competencia/models/competencia.model';
import {CompetenciaDropdownModel} from '../../models/competencia.model';
import {ColaboradorDropdownModel} from '../../models/colaborador-dropdown.model';

@Component({
  selector: 'app-colaborador-competencia-form',
  templateUrl: './vincular-competencia-form.component.html',
  styleUrls: ['./vincular-competencia-form.component.css']
})
export class VincularCompetenciaFormComponent implements OnInit {

    form: FormGroup;
    competencias: SelectItem[];
    nivel: SelectItem[];

    @Output() aoAdicionar = new EventEmitter<ColaboradorCompetenciaModel>();
    @Input() aoReceber;

  constructor(private fb: FormBuilder, private colaboradorService: ColaboradorService, private competenciaService: CompetenciaService) { }

  ngOnInit(): void {

      this.novoFormulario()
      this.listarCompetencias();
      this.listarNiveis();

  }

    listarCompetencias() {
        this.competenciaService.buscarDropdown().subscribe(
            resposta => {
                this.competencias = resposta;
            });
    }

    listarNiveis() {
        this.nivel = this.colaboradorService.buscarNivel();
    }

  novoFormulario() {

      this.form = this.fb.group({
          id_competencia: [null, [Validators.required]],
          nivel: [null,[Validators.required]]
      })

      // if( this.aoReceber !== undefined ){
      //
      //     this.aoReceber.data.colaboraCompetencia.forEach(el =>
      //       this.form.valcom
      //
      //       (
      //           this.form.patchValue({
      //               id_competencia: el.id_competencia,
      //               nivel: el.nivel
      //           })
      //       )
      //     )
      // }
      //
      // console.log(this.form.value)
  }

  adicionar() {
      if (this.form.valid) {
          this.aoAdicionar.emit(this.form.value)
      }
  }


}
