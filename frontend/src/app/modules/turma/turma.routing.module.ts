import { RouterModule } from '@angular/router';
import { NgModule } from "@angular/core";
import {ListarComponent} from "./components/listar/listar.component";

const turmasRoutes = [
    {path: '', component: ListarComponent}
];


@NgModule({
    imports: [ RouterModule.forChild(turmasRoutes)],
    exports: []
})
export class TurmasRoutingModule {}
