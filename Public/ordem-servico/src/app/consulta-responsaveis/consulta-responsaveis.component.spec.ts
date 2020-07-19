import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaResponsaveisComponent } from './consulta-responsaveis.component';

describe('ConsultaResponsaveisComponent', () => {
  let component: ConsultaResponsaveisComponent;
  let fixture: ComponentFixture<ConsultaResponsaveisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaResponsaveisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaResponsaveisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
