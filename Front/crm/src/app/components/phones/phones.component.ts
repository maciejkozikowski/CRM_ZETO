import { Component, OnInit, OnDestroy } from '@angular/core';


import { Subscription } from 'rxjs';
import { Telefony } from '../../models/Telefony';
import { PhonesService } from '../../services/phones.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-phones',
  templateUrl: './phones.component.html',
  styleUrls: ['./phones.component.css']
})
export class PhonesComponent implements OnInit, OnDestroy {

  title = 'crm';
  phones: Telefony[] = [];
  phone: Telefony;
  idklienta: number;

  subscriptions: Subscription[] = [];

  constructor(private phonesService: PhonesService,
              private router: Router) {}

  ngOnInit() {
    this.getAllPhones(); }

    getAllPhones() {
    this.subscriptions.push(this.phonesService.getAllPhones().subscribe(
      (data: Telefony[]) => {
        this.phones = data;
      },
      error => {
        console.error(error);
      }
    ));
  }

  addPhones() { }

  deletePhones(id: number) {
    if (confirm(`Czy chcesz usunąć numer?`)) {
      this.subscriptions.push(
        this.phonesService.deletePhone(id).subscribe(
          data => {
            console.log('Powodzenie: ', data);
            this.getAllPhones();
          },
          error => {
            console.log(error);
          }
        )
      );
    }
  }

  searchPhones(idklienta: number) {
    this.subscriptions.push(this.phonesService.searchByClientId(idklienta).subscribe(
      (data: Telefony[]) => {
        this.phones = data;
      },
      error => {
        console.error(error);
      }
    ));
  }

  ngOnDestroy() {
    this.subscriptions.forEach(x => x.unsubscribe());
  }

}
