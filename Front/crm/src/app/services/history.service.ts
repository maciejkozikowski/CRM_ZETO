import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import * as globalConfig from '../configs/globalVariables';
import { Historia } from '../models/Historia';

@Injectable({
  providedIn: 'root'
})
export class HistoryService {

  private server = globalConfig.serverURL;
  private searchByPhoneIdURL = this.server + 'historia/searchbyphoneid/{id}';

  constructor(private http: HttpClient) { }

  searchByPhoneId(phoneId: number){
    const url = this.searchByPhoneIdURL.replace('{id}', phoneId.toString());
    return this.http.get(url);
  }
}
