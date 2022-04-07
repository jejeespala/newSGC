import { RouterModule } from '@angular/router';
import { NgModule } from "@angular/core";
import {TurmaComponent} from './components/turma.component';

const turmasRoutes = [
    {path: '', component: TurmaComponent}
];


@NgModule({
    imports: [ RouterModule.forChild(turmasRoutes)],
    exports: []
})
export class TurmasRoutingModule {}
