import {Component, OnInit} from '@angular/core';
import {TabConfig, TabData} from "../../configs/TabDataConfig";

@Component({
  selector: 'app-tab',
  templateUrl: './tab.component.html',
  styleUrls: ['./tab.component.css']
})
export class TabComponent implements OnInit {

  tabConfig: TabData[];

  constructor() {
    this.tabConfig = [
      TabConfig.createLinkedInWithService(null),
      TabConfig.createTwitterWithService(null),
    ];
  }

  ngOnInit() {
  }

}
