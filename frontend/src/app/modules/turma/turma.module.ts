import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SharedModule} from '../../shared/shared.module';
import {TurmasRoutingModule} from './turma.routing.module';
import {TurmaService} from './service/turma.service';
import { ListarComponent } from './components/listar/listar.component';
import { FormComponent } from './components/form/form.component';
import {DialogService} from "primeng/dynamicdialog";



@NgModule({
  declarations: [ListarComponent, FormComponent],
  imports: [CommonModule,
      SharedModule,
      TurmasRoutingModule
  ],
    providers: [TurmaService, DialogService]
})
export class TurmaModule { }
