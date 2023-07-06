import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonarDetailsDialogComponent } from './donar-details-dialog.component';

describe('DonarDetailsDialogComponent', () => {
  let component: DonarDetailsDialogComponent;
  let fixture: ComponentFixture<DonarDetailsDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DonarDetailsDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DonarDetailsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
