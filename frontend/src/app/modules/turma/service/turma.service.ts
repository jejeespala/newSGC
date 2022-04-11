import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TurmaModel} from '../models/turma.model';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {StatusDropdownModel} from "../models/status.model";
import {ColaboradorCompetenciaModel} from '../../colaborador/models/colaborador-competencia.model';
import {take} from 'rxjs/operators';

const urlTurma: string = environment.apiUrl + '/turma';
const urlStatus: string = environment.apiUrl + '/status';


@Injectable({
  providedIn: 'root'
})
export class TurmaService {

  constructor(private httpClient: HttpClient) { }

    buscarTurma(): Observable<TurmaModel[]> {

      return this.httpClient.get<TurmaModel[]>(urlTurma);
    }

    buscarStatus(): Observable<StatusDropdownModel[]> {

        return this.httpClient.get<StatusDropdownModel[]>(urlStatus);
    }

    buscarTurmaId(id): Observable<TurmaModel> {
        return this.httpClient.get<TurmaModel>(`${urlTurma}/${id}`).pipe(take(1));
    }

    deletar(id) {

        return this.httpClient.delete(`${urlTurma}/${id}`).pipe(take(1));
    }




}
