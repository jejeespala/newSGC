import { CategoriaModel } from './../../competencia/models/categoria.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../../../environments/environment.prod';
import { Injectable } from '@angular/core';
import { ColaboradorModel } from '../models/colaborador.model';
import {CompetenciaDropdownModel} from '../models/competencia.model';
import {NivelModel} from '../models/nivel.model';
import {niveis} from './nivel.service';
import {ColaboradorPostModel} from '../models/colaboradorPost.model';
import {take} from 'rxjs/operators';
import {ColaboradorDropdownModel} from "../models/colaboradordropdown.model";


const urlCol: string = environment.apiUrl + '/colaborador';
const urlComp: string = environment.apiUrl + '/competencia/colaborador';
const urlColCompNivelMax: string = environment.apiUrl + '/colaborador/competencia';

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

  buscarNivel(): NivelModel[] {

      return niveis;
  }

  salvarColaborador(colaborador): Observable<ColaboradorPostModel> {

      return this.httpClient.post<ColaboradorPostModel>(urlCol, colaborador).pipe(take(1));

  }

  buscarColaboradorNivelMaximo(id): Observable<ColaboradorDropdownModel[]> {

      return this.httpClient.get<ColaboradorDropdownModel[]>(`${urlColCompNivelMax}/${id}`).pipe(take(1));

  }
}
