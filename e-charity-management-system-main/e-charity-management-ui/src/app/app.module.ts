import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material.module';

/* FormsModule */
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
/* Angular Flex Layout */
import { FlexLayoutModule } from "@angular/flex-layout";
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { DonationCardComponent } from './components/donation-card/donation-card.component';
import { DonationsComponent } from './components/donations/donations.component';
import { CreateDonationRequestComponent } from './components/ngo/create-donation-request/create-donation-request.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RequestsComponent } from './components/admin/requests/requests.component';
import { AdminDashboardComponent } from './components/admin/dashboard/dashboard.component';
import { NgChartsModule } from 'ng2-charts';
import { NGODashboardComponent } from './components/ngo/dashboard/dashboard.component';
import { DonarDetailsDialogComponent } from './components/ngo/donar-details-dialog/donar-details-dialog.component';
import { MatDialogModule, MAT_DIALOG_DEFAULT_OPTIONS } from '@angular/material/dialog';
import { UpdateProfileComponent } from './components/update-profile/update-profile.component';
import { UserDonationHistoryComponent } from './components/user-donation-history/user-donation-history.component';
import { NGODonationCardComponent } from './components/ngo/ngo-donation-card/ngo-donation-card.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    DonationCardComponent,
    DonationsComponent,
    CreateDonationRequestComponent,
    ProfileComponent,
    RequestsComponent,
    AdminDashboardComponent,   
    NGODashboardComponent, DonarDetailsDialogComponent, UpdateProfileComponent, UserDonationHistoryComponent,
    NGODonationCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    ReactiveFormsModule,
    FormsModule,
    FlexLayoutModule,
    NgChartsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
