import { ColaboradorModule } from './modules/colaborador/colaborador.module';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import {TurmaModule} from './modules/turma/turma.module';
import {CompetenciaModule} from './modules/competencia/competencia.module';

const routes: Routes = [
    { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros'} },
    { path: 'login-success', component: LoginSuccessComponent },
    { path: 'competencia', loadChildren: () => CompetenciaModule },
    { path: 'colaborador', loadChildren: () => ColaboradorModule },
    { path: 'turma', loadChildren: () => TurmaModule }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
