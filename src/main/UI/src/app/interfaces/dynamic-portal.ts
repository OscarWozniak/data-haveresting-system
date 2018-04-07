import {Observable} from "rxjs/Observable";
import {HistoryLogItem} from "../entities/HistoryLogItem";
import {TwitterHistory} from "../entities/TwitterHistory";
import {LinkedInHistory} from "../entities/LinkedInHistory";

export interface DynamicPortal {
  getAllHistory(): Observable<HistoryLogItem[]>;

  viewHistoryLog(id: number): Observable<LinkedInHistory> | Observable<TwitterHistory>;

  deleteHistory(id: number): Observable<void>;

  doClover(): Observable<HistoryLogItem[]>;
}
