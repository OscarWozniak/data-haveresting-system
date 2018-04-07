import {Component, Input, OnInit} from '@angular/core';
import {DynamicPortal} from "../../interfaces/dynamic-portal";
import {HistoryLogItem} from "../../entities/HistoryLogItem";

@Component({
  selector: 'app-croverable-website',
  templateUrl: './croverable-website.component.html',
  styleUrls: ['./croverable-website.component.css']
})
export class CroverableWebsiteComponent implements OnInit {

  @Input()
  title: string;
  @Input()
  service: DynamicPortal;

  logItems: HistoryLogItem[];

  constructor() {
  }

  ngOnInit() {
    // this.getAllHistory();
    console.log("tab changed?")
  }

  doClover() {
    this.service.doClover().subscribe(this.setLogItems);
  }

  getAllHistory() {
    this.service.getAllHistory().subscribe(this.setLogItems)

  }

  private setLogItems(logItems: HistoryLogItem[]): void {
    this.logItems = logItems;
  }
}
