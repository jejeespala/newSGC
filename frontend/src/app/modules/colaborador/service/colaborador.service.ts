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
import {CompetenciaPostModel} from "../../competencia/models/competenciaPost.model";
import {CompetenciaModel} from "../../competencia/models/competencia.model";
import {ColaboradorCompetenciaModel} from "../models/colaborador-competencia.model";


const urlCol: string = environment.apiUrl + '/colaborador';
const urlColComp: string = environment.apiUrl + '/colaborador_competencia';
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

  salvarColaborador(colaborador) {

      return this.httpClient.post(urlCol, colaborador).pipe(take(1));
  }

  buscarNivel(): NivelModel[] {

      return niveis;
  }

  buscarColaboradorNivelMaximo(id): Observable<ColaboradorDropdownModel[]> {

      return this.httpClient.get<ColaboradorDropdownModel[]>(`${urlColCompNivelMax}/${id}`).pipe(take(1));

  }

    buscarColaboradorId(id): Observable<ColaboradorPostModel> {
        return this.httpClient.get<ColaboradorPostModel>(`${urlCol}/${id}`).pipe(take(1));
    }

    buscarColaboradorCompetenciaId(id): Observable<ColaboradorCompetenciaModel[]> {
        return this.httpClient.get<ColaboradorCompetenciaModel[]>(`${urlColComp}/${id}`).pipe(take(1));
    }

    deletar(id) {

        return this.httpClient.delete(`${urlComp}/${id}`).pipe(take(1));
    }
}
