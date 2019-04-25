import { Component, OnInit, OnDestroy } from '@angular/core';
import { Klient } from '../../../models/Klient';
import { ClientService } from '../../../services/client.service';
import { Subscription } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent implements OnInit, OnDestroy {

  subscriptions: Subscription[] = [];

  client: Klient = new Klient();

  constructor(private clientService: ClientService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(data => {
      console.log(data)
      if (data.has('id')) {
        this.client.id = parseInt(data.get('id'), 10);
        this.getClient();
      }
    })
  }

  getClient() {
    this.subscriptions.push(this.clientService.getClient(this.client.id).subscribe(
      (data: Klient) => {
        this.client = data;
      },
      error => {
        console.log(error);
      }
    ));
  }

  save() {
    console.log(this.client);
    this.subscriptions.push(this.clientService.postClient(this.client).subscribe(
      data => {
        console.log('Powodzenie: ', data);
        this.router.navigate(['clients'])
      },
      error => {
        console.log(error);
      }
    ));
  }

  ngOnDestroy() {
    this.subscriptions.forEach(x => x.unsubscribe());
  }

}
