import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ColaboradorCompetenciaFormComponent } from './colaborador-competencia-form.component';

describe('ColaboradorCompetenciaFormComponent', () => {
  let component: ColaboradorCompetenciaFormComponent;
  let fixture: ComponentFixture<ColaboradorCompetenciaFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ColaboradorCompetenciaFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ColaboradorCompetenciaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
