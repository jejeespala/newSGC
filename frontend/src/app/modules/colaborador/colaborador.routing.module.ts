import { RouterModule } from '@angular/router';
import { NgModule } from "@angular/core";
import { ListarComponent } from './components/listar/listar.component';

const colaboradorRoutes = [
    {path: '', component: ListarComponent}
];


@NgModule({
    imports: [ RouterModule.forChild(colaboradorRoutes)],
    exports: []
})
export class ColaboradorRoutingModule {}
