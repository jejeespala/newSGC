import { CompetenciasRoutingModule } from './competencia.routing.module';
import { CompetenciaService } from './service/competencia.service';
import { SharedModule } from './../../shared/shared.module';
import { CompetenciaListarComponent } from './components/competencia-listar/competencia-listar.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [
    CompetenciaListarComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    CompetenciasRoutingModule
  ],
  providers: [CompetenciaService]
})
export class CompetenciaModule { }
