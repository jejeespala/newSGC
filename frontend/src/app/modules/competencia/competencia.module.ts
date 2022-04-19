import { CompetenciasRoutingModule } from './competencia.routing.module';
import { CompetenciaService } from './service/competencia.service';
import { SharedModule } from './../../shared/shared.module';
import { ListarComponent } from './components/listar/listar.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DialogService} from 'primeng/dynamicdialog';
import {FormBuilder, ReactiveFormsModule} from '@angular/forms';
import {FormComponent} from './components/form/form.component';
import {DynamicDialogConfig, DynamicDialogRef, MessageService} from 'primeng';
import {BlockUIModule, BlockUIService} from 'ng-block-ui';



@NgModule({
  declarations: [ListarComponent, FormComponent],
    imports: [
        CommonModule,
        SharedModule,
        CompetenciasRoutingModule,
        BlockUIModule
    ],
  providers: [CompetenciaService, DialogService, FormBuilder,
      MessageService, DynamicDialogConfig, DynamicDialogRef,
      BlockUIService]
})
export class CompetenciaModule { }
