import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NGODonationCardComponent } from './ngo-donation-card.component';

describe('NGODonationCardComponent', () => {
  let component: NGODonationCardComponent;
  let fixture: ComponentFixture<NGODonationCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NGODonationCardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NGODonationCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
