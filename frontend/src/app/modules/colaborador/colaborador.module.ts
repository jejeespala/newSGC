import { ColaboradorRoutingModule } from './colaborador.routing.module';
import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import {CommonModule, DatePipe} from '@angular/common';
import { ListarComponent } from './components/listar/listar.component';
import {ColaboradorService} from './service/colaborador.service';
import {FormComponent} from './components/form/form.component';
import {DialogService} from 'primeng/dynamicdialog';
import {VincularCompetenciaFormComponent} from './components/vincular-competencia-form/vincular-competencia-form.component';
import {DynamicDialogRef} from 'primeng';


@NgModule({
  declarations: [ListarComponent, FormComponent, VincularCompetenciaFormComponent],
    imports: [
        CommonModule,
        SharedModule,
        ColaboradorRoutingModule
    ],
  providers: [ColaboradorService, DialogService, DatePipe, DynamicDialogRef]
})
export class ColaboradorModule { }
