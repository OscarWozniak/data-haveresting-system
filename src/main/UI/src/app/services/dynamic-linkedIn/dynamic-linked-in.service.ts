import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DynamicPortal} from '../../interfaces/dynamic-portal';
import {Observable} from 'rxjs/Observable';
import {HistoryLogItem} from '../../entities/HistoryLogItem';
import {LinkedInHistory} from '../../entities/LinkedInHistory';

@Injectable()
export class DynamicLinkedInService implements DynamicPortal {
  getAllHistory(): Observable<HistoryLogItem[]> {
    return undefined;
  }

  viewHistoryLog(): Observable<LinkedInHistory> {
    return undefined;
  }

  deleteHistory(): Observable<void> {
    return undefined;
  }

  doClover(): Observable<HistoryLogItem[]> {
    return undefined;
  }


  constructor(private http: HttpClient) {
  }

}
