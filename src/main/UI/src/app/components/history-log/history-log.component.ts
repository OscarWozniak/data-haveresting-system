import {Component, Input, OnInit} from '@angular/core';
import {DynamicPortal} from "../../interfaces/dynamic-portal";

@Component({
  selector: 'app-history-log',
  templateUrl: './history-log.component.html',
  styleUrls: ['./history-log.component.scss']
})
export class HistoryLogComponent implements OnInit {

  @Input()
  id: number;
  @Input()
  user: string;
  @Input()
  date: string;
  @Input()
  count: number;
  @Input()
  service: DynamicPortal;

  constructor() {
  }

  ngOnInit() {
  }

  viewHistoryLog(){
    this.service.viewHistoryLog(this.id);
  }

  deleteHistoryLog(){
    this.service.deleteHistory(this.id);
  }
}
