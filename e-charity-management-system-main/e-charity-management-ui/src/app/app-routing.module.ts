import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin/dashboard/dashboard.component';
import { RequestsComponent } from './components/admin/requests/requests.component';
import { CreateDonationRequestComponent } from './components/ngo/create-donation-request/create-donation-request.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { DonationsComponent } from './components/donations/donations.component';
import { NGODashboardComponent } from './components/ngo/dashboard/dashboard.component';
import { UpdateProfileComponent } from './components/update-profile/update-profile.component';
import { UserDonationHistoryComponent } from './components/user-donation-history/user-donation-history.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'donation-requests', component: DonationsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'create-donation', component: CreateDonationRequestComponent },
  { path: 'requests', component: RequestsComponent },
  { path: 'admin-dashboard', component: AdminDashboardComponent },
  { path: 'ngo-dashboard', component: NGODashboardComponent},
  { path: 'update-profile', component: UpdateProfileComponent},
  { path: 'user-donation-history', component: UserDonationHistoryComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
