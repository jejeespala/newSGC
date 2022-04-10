import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CompetenciaModel} from '../models/competencia.model';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {CategoriaModel} from '../models/categoria.model';
import {CompetenciaPostModel} from '../models/competenciaPost.model';
import {take} from 'rxjs/operators';

const urlComp: string = environment.apiUrl + '/competencia';
const urlCat: string = environment.apiUrl + '/categoria';

@Injectable({
  providedIn: 'root'
})
export class CompetenciaService {

  constructor(private httpClient: HttpClient) { }

    buscarCompetencia(): Observable<CompetenciaModel[]> {
      return this.httpClient.get<CompetenciaModel[]>(urlComp);
    }

    buscarCategoria(): Observable<CategoriaModel[]> {
      return this.httpClient.get<CategoriaModel[]>(urlCat);
    }

    salvarCompetencia(competencia): Observable<CompetenciaPostModel> {
      return this.httpClient.post<CompetenciaPostModel>(urlComp, competencia).pipe(take(1));
    }

    buscarCompetenciaId(id): Observable<CompetenciaModel> {
        return this.httpClient.get<CompetenciaModel>(`${urlComp}/${id}`).pipe(take(1));
    }

}
