import { Routes } from '@angular/router';

export const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'login', redirectTo: 'app-login', pathMatch: 'full'},
  {path: 'register', redirectTo: 'app-registration', pathMatch: 'full'},
  {path: 'info', redirectTo: 'app-info', pathMatch: 'full'},
  {path: 'profile', redirectTo: 'app-profile', pathMatch: 'full'},
];
