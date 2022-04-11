import { ListarComponent } from './components/listar/listar.component';
import { RouterModule } from '@angular/router';
import {NgModule} from '@angular/core';


const competenciasRoutes = [
    {path: '', component: ListarComponent}
];


@NgModule({
    imports: [ RouterModule.forChild(competenciasRoutes)],
    exports: []
})
export class CompetenciasRoutingModule {}
