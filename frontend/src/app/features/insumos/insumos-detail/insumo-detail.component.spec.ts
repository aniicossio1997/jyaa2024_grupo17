import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsumoDetailComponent } from './insumo-detail.component';

describe('InsumosDetailComponent', () => {
  let component: InsumoDetailComponent;
  let fixture: ComponentFixture<InsumoDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InsumoDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsumoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
