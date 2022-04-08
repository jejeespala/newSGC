import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ColaboradorCompetenciaModel} from '../../models/colaborador-competencia.model';

@Component({
  selector: 'app-colaborador-competencia-form',
  templateUrl: './colaborador-competencia-form.component.html',
  styleUrls: ['./colaborador-competencia-form.component.css']
})
export class ColaboradorCompetenciaFormComponent implements OnInit {

    form: FormGroup;
    @Output() aoAdicionar = new EventEmitter<ColaboradorCompetenciaModel>();

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {

      this.novoFormulario()
  }

  novoFormulario() {

      this.form = this.fb.group({
          id_colaborador: [null],
          id_competencia: [null, [Validators.required]],
          nivel: [null,[Validators.required]]
      })
  }

  adicionar() {
      if (this.form.valid) {
          this.aoAdicionar.emit(this.form.value)
      }
  }




}
