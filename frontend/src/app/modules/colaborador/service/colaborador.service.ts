import { CategoriaModel } from './../../competencia/models/categoria.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../../../environments/environment.prod';
import { Injectable } from '@angular/core';
import { ColaboradorModel } from '../models/colaborador.model';
import {CompetenciaDropdownModel} from '../models/competencia.model';

const urlCol: string = environment.apiUrl + '/colaborador';
const urlComp: string = environment.apiUrl + '/competencia';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  constructor(private httpClient: HttpClient) { }

  buscarColaborador(): Observable<ColaboradorModel[]> {

    return this.httpClient.get<ColaboradorModel[]>(urlCol);
  }

  buscarCompetencia(): Observable<CompetenciaDropdownModel[]> {

      return this.httpClient.get<CompetenciaDropdownModel[]>(urlComp);
  }
}
