import { CompetenciaListarComponent } from './components/competencia-listar/competencia-listar.component';
import { RouterModule } from '@angular/router';
import {NgModule} from '@angular/core';


const competenciasRoutes = [
    {path: '', component: CompetenciaListarComponent}
];


@NgModule({
    imports: [ RouterModule.forChild(competenciasRoutes)],
    exports: []
})
export class CompetenciasRoutingModule {}
