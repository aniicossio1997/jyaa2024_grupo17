import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresoDetailComponent } from './ingreso-detail.component';

describe('IngresoDetailComponent', () => {
  let component: IngresoDetailComponent;
  let fixture: ComponentFixture<IngresoDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IngresoDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IngresoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
