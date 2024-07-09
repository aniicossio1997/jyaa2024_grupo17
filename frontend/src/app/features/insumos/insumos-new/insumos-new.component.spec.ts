import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsumosNewComponent } from './insumos-new.component';

describe('InsumosNewComponent', () => {
  let component: InsumosNewComponent;
  let fixture: ComponentFixture<InsumosNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InsumosNewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsumosNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
