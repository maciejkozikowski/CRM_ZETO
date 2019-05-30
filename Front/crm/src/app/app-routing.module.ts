import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientsListComponent } from './components/clients-list/clients-list.component';
import { ClientShowComponent } from './components/clients-list/client-show/client-show.component';
import { ClientFormComponent } from './components/clients-list/client-form/client-form.component';
import { PhonesComponent } from './components/phones/phones.component';
import { PhonesFormComponent } from './components/phones/phones-form/phones-form.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
// import { PmComponent } from './pm/pm.component';
import { AdminComponent } from './admin/admin.component';
import { HistoryComponent } from './components/history/history.component';
import { FactureComponent } from './components/facture/facture.component';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'clients', component: ClientsListComponent },
  { path: 'clients/show/:id', component: ClientsListComponent },
  { path: 'clients/form', component: ClientFormComponent },
  { path: 'clients/form/:id', component: ClientFormComponent },
  { path: 'clients/show/:pesel', component: ClientFormComponent },
  { path: 'phones', component: PhonesComponent },
  { path: 'phones/form', component: PhonesFormComponent },
  { path: 'phones/form/:id', component: PhonesFormComponent },
  { path: 'history/:phoneid', component: HistoryComponent },
  { path: 'facture/:clientid', component: FactureComponent },
  { path: 'clients/show/:idklienta', component: PhonesFormComponent },
  { path: 'home', component: HomeComponent },
  { path: 'user', component: UserComponent },
//  { path: 'pm', component: PmComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: RegisterComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
