import { CategoriaModel } from './../../competencia/models/categoria.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../../../environments/environment.prod';
import { Injectable } from '@angular/core';
import { ColaboradorModel } from '../models/colaborador.model';

const urlCol: string = environment.apiUrl + '/colaborador';
const urlCat: string = environment.apiUrl + '/categoria';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  constructor(private httpClient: HttpClient) { }

  buscarColaborador(): Observable<ColaboradorModel[]> {

    return this.httpClient.get<ColaboradorModel[]>(urlCol);
  } 
}
