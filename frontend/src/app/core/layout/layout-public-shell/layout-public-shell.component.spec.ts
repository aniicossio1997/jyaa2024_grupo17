import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutPublicShellComponent } from './layout-public-shell.component';

describe('LayoutPublicShellComponent', () => {
  let component: LayoutPublicShellComponent;
  let fixture: ComponentFixture<LayoutPublicShellComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LayoutPublicShellComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutPublicShellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
