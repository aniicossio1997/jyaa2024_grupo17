import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresoCambiarEstadoComponent } from './ingreso-cambiar-estado.component';

describe('IngresoCambiarEstadoComponent', () => {
  let component: IngresoCambiarEstadoComponent;
  let fixture: ComponentFixture<IngresoCambiarEstadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IngresoCambiarEstadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IngresoCambiarEstadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
