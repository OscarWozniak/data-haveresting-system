import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {LinkedInModel} from "../../shared/classes/LinkedIn.model";
import {DEFAULT_URL} from "../default/default.service";

@Injectable()
export class LinkedInService {

  constructor(private http: HttpClient) {
  }

  doClover(body: LinkedInModel): void {
    this.http.post(DEFAULT_URL + "/clover/linked-in", body);
  }
}
