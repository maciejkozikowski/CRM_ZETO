import { Component, OnInit, OnDestroy } from '@angular/core';


import { Subscription } from 'rxjs';
import { Klient } from '../../models/Klient';
import { ClientService } from '../../services/client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit, OnDestroy {

  title = 'crm';
  clients: Klient[] = [];
  client: Klient;

  subscriptions: Subscription[] = [];

  constructor(private clientService: ClientService,
              private router: Router) {}

  ngOnInit() {
    this.getAllClients(); 
  }

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

  addClient(){
    
  }

  deleteClient(id: number){
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

  ngOnDestroy() {
    this.subscriptions.forEach(x => x.unsubscribe());
  }

}
