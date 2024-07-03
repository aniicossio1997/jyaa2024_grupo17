import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarIngresosComponent } from './agregar-ingresos.component';

describe('AgregarIngresosComponent', () => {
  let component: AgregarIngresosComponent;
  let fixture: ComponentFixture<AgregarIngresosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AgregarIngresosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgregarIngresosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
