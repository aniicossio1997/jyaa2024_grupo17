import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriaNewComponent } from './materia-new.component';

describe('MateriaNewComponent', () => {
  let component: MateriaNewComponent;
  let fixture: ComponentFixture<MateriaNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MateriaNewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MateriaNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
