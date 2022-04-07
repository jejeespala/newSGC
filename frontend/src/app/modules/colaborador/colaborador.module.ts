import { ColaboradorRoutingModule } from './colaborador.routing.module';
import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ColaboradorListarComponent } from './components/colaborador-listar/colaborador-listar.component';
import {ColaboradorService} from './service/colaborador.service';



@NgModule({
  declarations: [ColaboradorListarComponent],
  imports: [
    CommonModule,
    SharedModule,
    ColaboradorRoutingModule
  ],
  providers: [ColaboradorService]
})
export class ColaboradorModule { }
