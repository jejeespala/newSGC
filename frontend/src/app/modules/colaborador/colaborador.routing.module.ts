import { RouterModule } from '@angular/router';
import { NgModule } from "@angular/core";
import { ColaboradorListarComponent } from './components/colaborador-listar/colaborador-listar.component';

const colaboradorRoutes = [
    {path: '', component: ColaboradorListarComponent}
];


@NgModule({
    imports: [ RouterModule.forChild(colaboradorRoutes)],
    exports: []
})
export class ColaboradorRoutingModule {}
