import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormIngredientesComponent } from './form-ingredientes.component';

describe('FormIngredientesComponent', () => {
  let component: FormIngredientesComponent;
  let fixture: ComponentFixture<FormIngredientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FormIngredientesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormIngredientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
