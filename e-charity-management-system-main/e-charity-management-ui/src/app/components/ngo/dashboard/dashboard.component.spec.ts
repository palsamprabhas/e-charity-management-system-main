import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NGODashboardComponent } from './dashboard.component';

describe('NGODashboardComponent', () => {
  let component: NGODashboardComponent;
  let fixture: ComponentFixture<NGODashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NGODashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NGODashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
