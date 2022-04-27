import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../../../environments/environment.prod';
import { Injectable } from '@angular/core';
import { ColaboradorModel } from '../models/colaborador.model';
import {NivelModel} from '../models/nivel.model';
import {niveis} from '../util/nivel.service';
import {ColaboradorPostModel} from '../models/colaboradorPost.model';
import {take} from 'rxjs/operators';
import {ColaboradorDropdownModel} from "../models/colaborador-dropdown.model";
import {ColaboradorCompetenciaNivelModel} from "../models/colaborador-competencia-nivel.model";
import {SenioridadeDropdownModel} from '../models/senioridade-dropdown.model';


const urlCol: string = environment.apiUrl + '/colaboradores';
const urlSenioridade: string = environment.apiUrl + '/senioridades';
const urlColComp: string = environment.apiUrl + '/colaboradores_competencias';
const urlComp: string = environment.apiUrl + '/competencias/colaboradores';
const urlColCompNivelMax: string = environment.apiUrl + '/colaboradores/competencias';

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

    buscarCompetenciaId(id): Observable<ColaboradorCompetenciaNivelModel[]> {
        return this.httpClient.get<ColaboradorCompetenciaNivelModel[]>(`${urlColComp}/${id}`).pipe(take(1));
    }

    deletar(id) {
        return this.httpClient.delete(`${urlCol}/${id}`).pipe(take(1));
    }

    buscarSenioridade(): Observable<SenioridadeDropdownModel[]> {
      return this.httpClient.get<SenioridadeDropdownModel[]>(urlSenioridade);
    }

    // carregarImagem(file): Observable<any> {
    //
    //   let formData = new FormData();
    //   formData.append("file", file, file.name);
    //
    // }
}
