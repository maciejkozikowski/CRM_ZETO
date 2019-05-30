import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import * as globalConfig from '../configs/globalVariables';


@Injectable({
  providedIn: 'root'
})
export class FactureService {

  private server = globalConfig.serverURL;
  private searchByClientIdURL = this.server + 'faktura/getfacture/{id}';

  constructor(private http: HttpClient) { }

  searchByClientId(clientId: number){
    const url = this.searchByClientIdURL.replace('{id}', clientId.toString());
    return this.http.get(url);
  }
}
