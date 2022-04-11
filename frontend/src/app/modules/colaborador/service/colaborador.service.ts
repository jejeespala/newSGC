import { CategoriaModel } from './../../competencia/models/categoria.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../../../environments/environment.prod';
import { Injectable } from '@angular/core';
import { ColaboradorModel } from '../models/colaborador.model';
import {CompetenciaDropdownModel} from '../models/competencia.model';
import {NivelModel} from '../models/nivel.model';
import {niveis} from '../util/nivel.service';
import {ColaboradorPostModel} from '../models/colaboradorPost.model';
import {take} from 'rxjs/operators';
import {ColaboradorDropdownModel} from "../models/colaboradordropdown.model";
import {ColaboradorCompetenciaModel} from "../models/colaborador-competencia.model";


const urlCol: string = environment.apiUrl + '/colaboradores';
const urlColComp: string = environment.apiUrl + '/colaboradores_competencias';
const urlComp: string = environment.apiUrl + '/competencia/colaborador';
const urlColCompNivelMax: string = environment.apiUrl + '/colaborador/competencia';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  constructor(private httpClient: HttpClient) { }

  buscar(): Observable<ColaboradorModel[]> {
    return this.httpClient.get<ColaboradorModel[]>(urlCol);
  }

  salvar(colaborador) {
      return this.httpClient.post(urlCol, colaborador).pipe(take(1));
  }

  buscarNivel(): NivelModel[] {
      return niveis;
  }

  buscarNivelMaximo(id): Observable<ColaboradorDropdownModel[]> {
      return this.httpClient.get<ColaboradorDropdownModel[]>(`${urlColCompNivelMax}/${id}`).pipe(take(1));
  }

    buscarId(id): Observable<ColaboradorPostModel> {
        return this.httpClient.get<ColaboradorPostModel>(`${urlCol}/${id}`).pipe(take(1));
    }

    buscarCompetenciaId(id): Observable<ColaboradorCompetenciaModel[]> {
        return this.httpClient.get<ColaboradorCompetenciaModel[]>(`${urlColComp}/${id}`).pipe(take(1));
    }

    deletar(id) {
        return this.httpClient.delete(`${urlComp}/${id}`).pipe(take(1));
    }
}
