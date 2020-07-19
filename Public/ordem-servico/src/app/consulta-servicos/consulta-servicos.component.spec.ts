import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaServicosComponent } from './consulta-servicos.component';

describe('ConsultaServicosComponent', () => {
  let component: ConsultaServicosComponent;
  let fixture: ComponentFixture<ConsultaServicosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaServicosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaServicosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
