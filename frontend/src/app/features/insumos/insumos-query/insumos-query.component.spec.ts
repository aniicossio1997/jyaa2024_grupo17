import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsumosQueryComponent } from './insumos-query.component';

describe('InsumosQueryComponent', () => {
  let component: InsumosQueryComponent;
  let fixture: ComponentFixture<InsumosQueryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InsumosQueryComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsumosQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
