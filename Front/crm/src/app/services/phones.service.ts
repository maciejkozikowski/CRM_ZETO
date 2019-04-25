import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import * as globalConfig from '../configs/globalVariables'
import { Telefony } from '../models/Telefony';


@Injectable({
  providedIn: 'root'
})
export class PhonesService {

  private server = globalConfig.serverURL;
  private allPhoneURL = this.server + 'telefon/all';
  private postPhoneURL = this.server + 'telefon/add';
  private getIdURL = this.server + 'telefon/searchbyid/{id}';
  private deletePhoneURL = this.server + 'telefon/delete/{id}';
  private searchByClientIdURL = this.server + 'telefon/searchbyidklienta/{idklienta}';


  constructor(private http: HttpClient) { }

  getAllPhones() {
    return this.http.get(this.allPhoneURL);
  }

  postPhone(phone: Telefony) {
    return this.http.post(this.postPhoneURL, phone);
  }

  getPhone(id: number) {
    const url = this.getIdURL.replace('{id}', id.toString());
    return this.http.get(url);
  }

  deletePhone(id: number) {
    const url = this.deletePhoneURL.replace('{id}', id.toString());
    return this.http.delete(url);
  }

  searchByClientId(idklienta: number){
    const url = this.searchByClientIdURL.replace('{idklienta}', idklienta.toString());
    return this.http.get(url);
  }
}
