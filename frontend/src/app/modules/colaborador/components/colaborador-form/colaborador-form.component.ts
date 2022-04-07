import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {SelectItem} from 'primeng';
import {ColaboradorService} from '../../service/colaborador.service';

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './colaborador-form.component.html',
  styleUrls: ['./colaborador-form.component.css']
})
export class ColaboradorFormComponent implements OnInit {

    form: FormBuilder;
    competencia: SelectItem[];

  constructor(private colaboradorService: ColaboradorService) { }

  ngOnInit(): void {
      // this.listarCompetencias();
  }

  listarCompetencias() {

      this.colaboradorService.buscarCompetencia().subscribe(
          resposta => this.competencia
      );

  }


}
