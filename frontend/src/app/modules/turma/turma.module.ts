import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SharedModule} from '../../shared/shared.module';
import {TurmasRoutingModule} from './turma.routing.module';
import {TurmaService} from './service/turma.service';
import { TurmaListarComponent } from './components/turma-listar/turma-listar.component';
import { TurmaFormComponent } from './components/turma-form/turma-form.component';
import {DialogService} from "primeng/dynamicdialog";



@NgModule({
  declarations: [TurmaListarComponent, TurmaFormComponent],
  imports: [CommonModule,
      SharedModule,
      TurmasRoutingModule
  ],
    providers: [TurmaService, DialogService]
})
export class TurmaModule { }
