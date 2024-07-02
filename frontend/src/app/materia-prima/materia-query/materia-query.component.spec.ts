import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriaQueryComponent } from './materia-query.component';

describe('MateriaQueryComponent', () => {
  let component: MateriaQueryComponent;
  let fixture: ComponentFixture<MateriaQueryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MateriaQueryComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MateriaQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
