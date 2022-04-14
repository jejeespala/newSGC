import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ColaboradorCompetenciaNivelModel} from '../../models/colaborador-competencia-nivel.model';
import {ColaboradorService} from "../../service/colaborador.service";
import {SelectItem} from 'primeng';
import {CompetenciaService} from '../../../competencia/service/competencia.service';
import {CompetenciaNivelModel} from '../../models/competencia-nivel.model';

@Component({
  selector: 'app-colaborador-competencia-form',
  templateUrl: './vincular-competencia-form.component.html',
  styleUrls: ['./vincular-competencia-form.component.css']
})
export class VincularCompetenciaFormComponent implements OnInit {

    formArr: FormArray;
    competencias: SelectItem[];
    nivel: SelectItem[];
    comps: CompetenciaNivelModel[] = [];
    //compForm: FormGroup;

    @Output() aoAdicionar = new EventEmitter<ColaboradorCompetenciaNivelModel>();
    @Input() aoReceber;
    @Input() formPai: FormGroup;

  constructor(private fb: FormBuilder, private colaboradorService: ColaboradorService, private competenciaService: CompetenciaService) { }

  ngOnInit(): void {
      this.novoFormulario()
      this.listarCompetencias();
      this.listarNiveis();
  }

    listarCompetencias() {
        this.competenciaService.buscarDropdown().subscribe(
            resposta => {
                this.competencias = resposta;
            });
    }

    listarNiveis() {
        this.nivel = this.colaboradorService.buscarNivel();
    }

    get vai() {
        return this.formPai.controls["vai"] as FormArray;
    }

  novoFormulario() {

      this.formArr = this.fb.array([])
      this.formPai.addControl('vai', this.formArr);
      this.adicionar();
      console.log(this.formPai.value);


      // if( this.aoReceber !== undefined ){
      //
      //     this.aoReceber.data.colaboraCompetencia.forEach(el =>
      //       this.form.valcom
      //
      //       (
      //           this.form.patchValue({
      //               idCompetencia: el.idCompetencia,
      //               nivel: el.nivel
      //           })
      //       )
      //     )
      // }
      //
      // console.log(this.form.value)
  }

    // get form() {
    //     return this.form as FormArray;
    // }

  adicionar() {
      // if (this.form.valid) {
      //     this.aoAdicionar.emit(this.form.value)
      // }
      const compForm = this.fb.group({
          idCompetencia: ['', Validators.required],
          nivel: ['', Validators.required]
      });

      this.formPai.get('vai').value.push(compForm.value);
  }

}
