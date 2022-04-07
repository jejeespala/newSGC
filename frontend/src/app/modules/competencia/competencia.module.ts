import { CompetenciasRoutingModule } from './competencia.routing.module';
import { CompetenciaService } from './service/competencia.service';
import { SharedModule } from './../../shared/shared.module';
import { CompetenciaListarComponent } from './components/competencia-listar/competencia-listar.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DialogService} from 'primeng/dynamicdialog';



@NgModule({
  declarations: [CompetenciaListarComponent],
  imports: [
    CommonModule,
    SharedModule,
    CompetenciasRoutingModule
  ],
  providers: [CompetenciaService, DialogService]
})
export class CompetenciaModule { }
