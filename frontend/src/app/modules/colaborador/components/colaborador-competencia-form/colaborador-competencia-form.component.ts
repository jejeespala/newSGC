import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ColaboradorCompetenciaModel} from '../../models/colaborador-competencia.model';
import {ColaboradorService} from "../../service/colaborador.service";
import {SelectItem} from 'primeng';

@Component({
  selector: 'app-colaborador-competencia-form',
  templateUrl: './colaborador-competencia-form.component.html',
  styleUrls: ['./colaborador-competencia-form.component.css']
})
export class ColaboradorCompetenciaFormComponent implements OnInit {

    form: FormGroup;
    competencia: SelectItem[];
    nivel: SelectItem[];

    @Output() aoAdicionar = new EventEmitter<ColaboradorCompetenciaModel>();
    @Input() aoReceber;

  constructor(private fb: FormBuilder, private colaboradorService: ColaboradorService) { }

  ngOnInit(): void {

      this.novoFormulario()
      this.listarCompetencias();
      this.listarNiveis();
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

  novoFormulario() {

      this.form = this.fb.group({
          id_competencia: [null, [Validators.required]],
          nivel: [null,[Validators.required]]
      })

      // if( this.aoReceber !== undefined ){
      //
      //     this.aoReceber.data.colaboraCompetencia.forEach(el =>
      //       this.form.val
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
