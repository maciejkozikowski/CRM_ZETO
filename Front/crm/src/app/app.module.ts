import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ClientsListComponent } from './components/clients-list/clients-list.component';
import { ClientFormComponent } from './components/clients-list/client-form/client-form.component';
import { ClientShowComponent } from './components/clients-list/client-show/client-show.component';
import { ClientService } from './services/client.service';
import { PhonesService } from './services/phones.service';
import { PhonesComponent } from './components/phones/phones.component';
import { PhonesShowComponent } from './components/phones/phones-show/phones-show.component';
import { PhonesFormComponent } from './components/phones/phones-form/phones-form.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
// import { PmComponent } from './pm/pm.component';
import { AdminComponent } from './admin/admin.component';

import { httpInterceptorProviders } from './auth/auth-interceptor';

import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';


@NgModule({
  declarations: [
    AppComponent,
    ClientsListComponent,
    ClientFormComponent,
    ClientShowComponent,
    PhonesComponent,
    PhonesShowComponent,
    PhonesFormComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    UserComponent,
    // PmComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot()
  ],
  exports: [BsDropdownModule, TooltipModule, ModalModule],
  
  providers: [
    ClientService, 
    PhonesService,
    httpInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
export class AppBootstrapModule {}