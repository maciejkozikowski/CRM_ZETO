import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ClientsListComponent } from './components/clients-list/clients-list.component';
import { ClientShowComponent } from './components/clients-list/client-show/client-show.component';
import { ClientFormComponent } from './components/clients-list/client-form/client-form.component';

const routes: Routes = [
  { path: '', component: AppComponent },
  { path: 'clients', component: ClientsListComponent },
  { path: 'clients/show/:id', component: ClientShowComponent },
  { path: 'clients/form', component: ClientFormComponent },
  { path: 'clients/form/:id', component: ClientFormComponent },
  { path: 'clients/show/:pesel', component: ClientFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
