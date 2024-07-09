import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsumosEditComponent } from './insumos-edit.component';

describe('InsumosEditComponent', () => {
  let component: InsumosEditComponent;
  let fixture: ComponentFixture<InsumosEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InsumosEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsumosEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
