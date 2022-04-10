import { RouterModule } from '@angular/router';
import { NgModule } from "@angular/core";
import {TurmaListarComponent} from "./components/turma-listar/turma-listar.component";

const turmasRoutes = [
    {path: '', component: TurmaListarComponent}
];


@NgModule({
    imports: [ RouterModule.forChild(turmasRoutes)],
    exports: []
})
export class TurmasRoutingModule {}
