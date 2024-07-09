import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsumoAddIngresoComponent } from './insumo-add-ingreso.component';

describe('InsumoAddIngresoComponent', () => {
  let component: InsumoAddIngresoComponent;
  let fixture: ComponentFixture<InsumoAddIngresoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InsumoAddIngresoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsumoAddIngresoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
