import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TurmaModel} from '../models/turma.model';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';

const urlTurma: string = environment.apiUrl + '/turma';

@Injectable({
  providedIn: 'root'
})
export class TurmaService {

  constructor(private httpClient: HttpClient) { }

    buscarTurma(): Observable<TurmaModel[]> {

      return this.httpClient.get<TurmaModel[]>(urlTurma);
    }




}
