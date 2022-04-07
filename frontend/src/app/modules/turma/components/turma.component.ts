import { Component, OnInit } from '@angular/core';
import {TurmaService} from '../service/turma.service';
import {TurmaModel} from '../models/turma.model';

@Component({
  selector: 'app-turma',
  templateUrl: './turma.component.html',
  styleUrls: ['./turma.component.css']
})
export class TurmaComponent implements OnInit {

    turmas: TurmaModel[];

  constructor(private turmaService: TurmaService) { }

  ngOnInit(): void {

      this.listarTurma();
  }

  listarTurma() {
      this.turmaService.buscarTurma().subscribe(resposta => {

          this.turmas = resposta;
      });
  }
}
