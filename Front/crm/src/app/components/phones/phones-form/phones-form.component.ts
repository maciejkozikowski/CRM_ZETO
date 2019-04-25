import { Component, OnInit, OnDestroy } from '@angular/core';
import {Telefony } from '../../../models/Telefony';
import { PhonesService } from '../../../services/phones.service';
import { Subscription } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-phones-form',
  templateUrl: './phones-form.component.html',
  styleUrls: ['./phones-form.component.css']
})
export class PhonesFormComponent implements OnInit, OnDestroy {

  subscriptions: Subscription[] = [];

  phone: Telefony = new Telefony();

  constructor(private phonesService: PhonesService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(data => {
      console.log(data)
      if (data.has('id')) {
        this.phone.id = parseInt(data.get('id'), 10);
        this.getPhones();
      }
    })
  }

  getPhones() {
    this.subscriptions.push(this.phonesService.getPhone(this.phone.id).subscribe(
      (data: Telefony) => {
        this.phone = data;
      },
      error => {
        console.log(error);
      }
    ));
  }

  save() {
    console.log(this.phone);
    this.subscriptions.push(this.phonesService.postPhone(this.phone).subscribe(
      data => {
        console.log('Powodzenie: ', data);
        this.router.navigate(['phones'])
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