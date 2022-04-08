import { ColaboradorRoutingModule } from './colaborador.routing.module';
import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ColaboradorListarComponent } from './components/colaborador-listar/colaborador-listar.component';
import {ColaboradorService} from './service/colaborador.service';
import {ColaboradorFormComponent} from './components/colaborador-form/colaborador-form.component';
import {DialogService} from 'primeng/dynamicdialog';
import {ColaboradorCompetenciaFormComponent} from './components/colaborador-competencia-form/colaborador-competencia-form.component';


@NgModule({
  declarations: [ColaboradorListarComponent, ColaboradorFormComponent, ColaboradorCompetenciaFormComponent],
    imports: [
        CommonModule,
        SharedModule,
        ColaboradorRoutingModule
    ],
  providers: [ColaboradorService, DialogService]
})
export class ColaboradorModule { }
