import { Component, OnInit, OnDestroy } from '@angular/core';


import { Subscription } from 'rxjs';
import { Klient } from '../../models/Klient';
import { ClientService } from '../../services/client.service';
import { Router } from '@angular/router';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit, OnDestroy {

  title = 'crm';
  clients: Klient[] = [];
  client: Klient;
  pesel: string;
  info: any;

  subscriptions: Subscription[] = [];

  constructor(private clientService: ClientService,
              private router: Router,
              private authService: AuthService) {}

  ngOnInit() {
    this.info = this.authService.checkIfLoggedIn();
    this.getAllClients(); }

  getAllClients() {
    this.subscriptions.push(this.clientService.getAllClients().subscribe(
      (data: Klient[]) => {
        this.clients = data;
      },
      error => {
        console.error(error);
      }
    ));
  }

  addClient() { }

  deleteClient(id: number) {
    if (confirm(`Czy chcesz usunąć klienta o id=${id}?`)) {
      this.subscriptions.push(
        this.clientService.deleteClient(id).subscribe(
          data => {
            console.log('Powodzenie: ', data);
            this.getAllClients();
          },
          error => {
            console.log(error);
          }
        )
      );
    }
  }

  searchClient(pesel: string) {
    this.subscriptions.push(this.clientService.searchClient(pesel).subscribe(
      (data: Klient[]) => {
        this.clients = data;
      },
      error => {
        console.error(error);
      }
    ));
  }

  showFacture(clientId: number){
    this.router.navigate(['../facture/' + clientId.toString()])
  }

  ngOnDestroy() {
    this.subscriptions.forEach(x => x.unsubscribe());
  }

}
