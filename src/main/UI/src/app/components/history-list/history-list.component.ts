import {Component, Input, OnInit} from '@angular/core';
import {DynamicPortal} from "../../interfaces/dynamic-portal";
import {HistoryLogItem} from "../../entities/HistoryLogItem";

@Component({
  selector: 'app-history-list',
  templateUrl: './history-list.component.html',
  styleUrls: ['./history-list.component.css']
})
export class HistoryListComponent implements OnInit {

  @Input()
  logItems: HistoryLogItem[];

  @Input()
  service: DynamicPortal;

  history =[
    {user:"Oskar1", date:"02.04.2017", count:37},
    {user:"Oskar2", date:"02.04.2017", count:37},
  ];

  constructor() {}

  ngOnInit() {
  }

}
