import { Component, OnInit, OnDestroy } from '@angular/core';


import { Subscription } from 'rxjs';
import { Telefony } from '../../models/Telefony';
import { PhonesService } from '../../services/phones.service';
import { Router } from '@angular/router';
import { AuthService } from '../../auth/auth.service';

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
  info: any;
  public phoneId: number;

  subscriptions: Subscription[] = [];

  constructor(private phonesService: PhonesService,
              private router: Router,
              private authService: AuthService) {}

  ngOnInit() {
    this.getAllPhones(); 
    this.info = this.authService.checkIfLoggedIn();
  }

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

  showHistory(phoneId: number){
    this.router.navigate(['../history/' + phoneId.toString()])
  }

  ngOnDestroy() {
    this.subscriptions.forEach(x => x.unsubscribe());
  }

}
