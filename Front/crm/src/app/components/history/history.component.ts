import { Component, OnInit, OnDestroy } from '@angular/core';


import { Subscription } from 'rxjs';
import { Historia } from '../../models/Historia';
import { HistoryService } from '../../services/history.service'
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../../auth/auth.service';
import { PhonesComponent } from '../phones/phones.component'

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit, OnDestroy {

  title = 'crm';
  history: Historia[] = [];
  phoneId: number;
  info: any;

  subscriptions: Subscription[] = [];

  constructor(private historyService: HistoryService,
              private router: Router,
              private authService: AuthService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.info = this.authService.checkIfLoggedIn();
    this.route.paramMap.subscribe(data => {
      if(data.has('phoneid')) {
        this.phoneId = parseInt(data.get('phoneid'), 10);
        this.getHistory(this.phoneId);
      }
    })
  }

  getHistory(phoneId: number){
    this.subscriptions.push(this.historyService.searchByPhoneId(phoneId).subscribe(
      (data: Historia[]) => {
        this.history = data;
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
