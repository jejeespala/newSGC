import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SharedModule} from '../../shared/shared.module';
import {TurmasRoutingModule} from './turma.routing.module';
import {TurmaService} from './service/turma.service';
import {TurmaComponent} from './components/turma.component';



@NgModule({
  declarations: [TurmaComponent],
  imports: [CommonModule,
      SharedModule,
      TurmasRoutingModule
  ],
    providers: [TurmaService]
})
export class TurmaModule { }
