import {Component, OnInit} from '@angular/core';
import {TabConfig, TabData} from "../../configs/TabDataConfig";
import {DynamicTwitterService} from "../../services/dynamic-twitter/dynamic-twitter.service";
import {DynamicLinkedInService} from "../../services/dynamic-linkedIn/dynamic-linked-in.service";

@Component({
  selector: 'app-tab',
  templateUrl: './tab.component.html',
  styleUrls: ['./tab.component.css']
})
export class TabComponent implements OnInit {

  tabConfig: TabData[];

  constructor(twitterService: DynamicTwitterService, linkedInService: DynamicLinkedInService) {
    this.tabConfig = [
      TabConfig.createLinkedInWithService(linkedInService),
      TabConfig.createTwitterWithService(twitterService),
    ];
  }

  ngOnInit() {
  }

}
