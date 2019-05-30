import { Component, OnInit, OnDestroy } from '@angular/core';

import { Subscription } from 'rxjs';
import { Faktura} from '../../models/Faktura';
import { FactureService } from '../../services/facture.service'
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-facture',
  templateUrl: './facture.component.html',
  styleUrls: ['./facture.component.css']
})
export class FactureComponent implements OnInit, OnDestroy {

  title = 'crm';
  facture: Faktura[] = [];
  clientId: number;
  info: any;
  subscriptions: Subscription[] = [];
  rows: any[] = [];
  row: any[];
  count: number;

  constructor(private factureService: FactureService,
              private router: Router,
              private authService: AuthService,
              private route: ActivatedRoute) { }

   ngOnInit() {
    this.info = this.authService.checkIfLoggedIn();
    this.route.paramMap.subscribe(data => {
      if(data.has('clientid')) {
        this.clientId = parseInt(data.get('clientid'), 10);
        this.getFacture(this.clientId);
      }
    })
  }
  getFacture(clientId: number){
    this.subscriptions.push(this.factureService.searchByClientId(clientId).subscribe(
      (data: Faktura[]) => {
      this.facture = data;
      this.count = this.facture[0].telefony.length;
        for (let i = 0; i < this.count; i++){
          this.row = [this.facture[0].telefony[i], this.facture[0].oplaty[i]]
          this.rows.push(this.row);
        }
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
