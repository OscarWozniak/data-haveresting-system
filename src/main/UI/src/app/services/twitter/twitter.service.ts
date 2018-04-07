import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TwitterModel} from "../../shared/classes/Twitter.model";
import {DEFAULT_URL} from "../default/default.service";

@Injectable()
export class TwitterService {

  constructor(private http: HttpClient) {
  }

  doClover(body: TwitterModel): void {
    this.http.post(DEFAULT_URL + "/clover/twitter", body);
  }
}
