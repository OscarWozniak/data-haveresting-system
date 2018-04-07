import {Injectable} from '@angular/core';
import {DynamicPortal} from "../../interfaces/dynamic-portal";
import {Observable} from "rxjs/Observable";
import {HistoryLogItem} from "../../entities/HistoryLogItem";
import {TwitterHistory} from "../../entities/TwitterHistory";

// const twitterTabRequests = new TabRequests(
//   "/clover/twitter",
//   "history/twitter",
//   "history/",
//   "history/",
// );


@Injectable()
export class DynamicTwitterService implements DynamicPortal {
  getAllHistory(): Observable<HistoryLogItem[]> {
    return undefined;
  }

  viewHistoryLog(): Observable<TwitterHistory> {
    return undefined;
  }

  deleteHistory(): Observable<void> {
    return undefined;
  }

  doClover(): Observable<HistoryLogItem[]> {
    return undefined;
  }

  constructor() {
  }

}
