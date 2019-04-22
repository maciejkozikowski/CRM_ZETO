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

@NgModule({
  declarations: [
    AppComponent,
    ClientsListComponent,
    ClientFormComponent,
    ClientShowComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
