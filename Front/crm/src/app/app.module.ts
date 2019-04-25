import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
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

@NgModule({
  declarations: [
    AppComponent,
    ClientsListComponent,
    ClientFormComponent,
    ClientShowComponent,
    PhonesComponent,
    PhonesShowComponent,
    PhonesFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    ClientService, 
    PhonesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
