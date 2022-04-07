import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SelectItem} from 'primeng';
import {CompetenciaService} from '../../service/competencia.service';

@Component({
  selector: 'app-competencia-form',
  templateUrl: './competencia-form.component.html',
  styleUrls: ['./competencia-form.component.css']
})
export class CompetenciaFormComponent implements OnInit {

    categorias: SelectItem[];
    form: FormGroup;


  constructor(private fb: FormBuilder, private competenciaService: CompetenciaService) { }

  ngOnInit(): void {
      this.novoFormulario();
      this.listarCategoria();
  }

  novoFormulario() {

      this.form = this.fb.group({
          id: [null],
          nome: [null, [Validators.required, Validators.minLength(3)]],
          descricao: [null, [Validators.required, Validators.minLength(3)]]
      });
  }

  listarCategoria() {

      this.competenciaService.buscarCategoria().subscribe(resposta => {
          this.categorias = resposta;
      });

  }

}
