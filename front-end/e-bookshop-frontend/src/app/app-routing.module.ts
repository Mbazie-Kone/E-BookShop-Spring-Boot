import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { ContactsComponent } from './contacts/contacts.component';

const routes: Routes = [
  {path:'', component: IndexComponent},
  {path:'dashboard', component: DashboardComponent},
  {path:'login', component: LoginComponent},
  {path:'contacts', component: ContactsComponent},
  {path:'contacts/:id', component: ContactsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
