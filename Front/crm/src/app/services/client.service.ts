import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import * as globalConfig from '../configs/globalVariables'
import { Klient } from '../models/Klient';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private server = globalConfig.serverURL;

  private allClientsURL = this.server + 'klienci/all';
  private postClientURL = this.server + 'klienci/add';
  private getClientURL = this.server + 'klienci/searchbyid/{id}';
  private deleteClientURL = this.server + 'klienci/delete/{id}';

  constructor(private http: HttpClient) {}

  getAllClients() {
    return this.http.get(this.allClientsURL);
  }

  postClient(client: Klient) {
    return this.http.post(this.postClientURL, client);
  }

  getClient(id: number) {
    const url = this.getClientURL.replace('{id}', id.toString());
    return this.http.get(url);
  }

  deleteClient(id: number) {
    const url = this.deleteClientURL.replace('{id}', id.toString());
    return this.http.delete(url);
  }

}
