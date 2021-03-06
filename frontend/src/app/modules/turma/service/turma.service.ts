import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TurmaModel} from '../models/turma.model';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {StatusDropdownModel} from "../models/status.model";
import {take} from 'rxjs/operators';
import {TurmaColaboradorCompetenciaModel} from '../models/colaborador-competencia.model';

const urlTurma: string = environment.apiUrl + '/turmas';
const urlTurmaCol: string = environment.apiUrl + '/turmas_colaboradores_competencias';
const urlStatus: string = environment.apiUrl + '/status';


@Injectable({
  providedIn: 'root'
})
export class TurmaService {

  constructor(private httpClient: HttpClient) { }

    buscar(): Observable<TurmaModel[]> {
      return this.httpClient.get<TurmaModel[]>(urlTurma);
    }

    buscarStatus(): Observable<StatusDropdownModel[]> {
        return this.httpClient.get<StatusDropdownModel[]>(urlStatus);
    }

    buscarId(id): Observable<TurmaModel> {
        return this.httpClient.get<TurmaModel>(`${urlTurma}/${id}`).pipe(take(1));
    }

    buscarColaboradorId(id): Observable<TurmaColaboradorCompetenciaModel[]> {
        return this.httpClient.get<TurmaColaboradorCompetenciaModel[]>(`${urlTurmaCol}/${id}`);
    }

    deletar(id) {
        return this.httpClient.delete(`${urlTurma}/${id}`).pipe(take(1));
    }




}
