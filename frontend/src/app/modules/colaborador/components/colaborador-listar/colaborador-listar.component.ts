import { ColaboradorService } from './../../service/colaborador.service';
import { ColaboradorModel } from './../../models/colaborador.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-colaborador-listar',
  templateUrl: './colaborador-listar.component.html',
  styleUrls: ['./colaborador-listar.component.css']
})
export class ColaboradorListarComponent implements OnInit {

  colaboradores : ColaboradorModel[]


  constructor(private colaboradorService: ColaboradorService) { }

  ngOnInit(): void {

    this.listarColaboradores();
    
  }

  listarColaboradores() {

    this.colaboradorService.buscarColaborador().subscribe(resposta => {
      this.colaboradores = resposta;
    });

  }

}
