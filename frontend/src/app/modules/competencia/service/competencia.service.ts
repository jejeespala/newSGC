import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CompetenciaModel} from '../models/competencia.model';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {CategoriaModel} from '../models/categoria.model';
import {CompetenciaFormModel} from '../models/competencia-form.model';
import {take} from 'rxjs/operators';
import {CompetenciaDropdownModel} from '../../colaborador/models/competencia.model';

const url: string = environment.apiUrl + '/competencias'
const urlComp: string = environment.apiUrl + '/competencias/dropdown';
const urlCat: string = environment.apiUrl + '/categorias';

@Injectable({
  providedIn: 'root'
})
export class CompetenciaService {

  constructor(private httpClient: HttpClient) { }

    buscar(): Observable<CompetenciaModel[]> {
      return this.httpClient.get<CompetenciaModel[]>(url);
    }

    buscarDropdown(): Observable<CompetenciaDropdownModel[]> {
        return this.httpClient.get<CompetenciaDropdownModel[]>(urlComp);
    }

    buscarCategoria(): Observable<CategoriaModel[]> {
      return this.httpClient.get<CategoriaModel[]>(urlCat);
    }

    salvar(competencia): Observable<CompetenciaFormModel> {
      return this.httpClient.post<CompetenciaFormModel>(urlComp, competencia).pipe(take(1));
    }

    buscarId(id): Observable<CompetenciaFormModel> {
        return this.httpClient.get<CompetenciaFormModel>(`${url}/${id}`).pipe(take(1));
    }

    deletar(id) {
        return this.httpClient.delete(`${urlComp}/${id}`).pipe(take(1));
    }

}
