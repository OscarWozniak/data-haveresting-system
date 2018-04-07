import {DynamicPortal} from "../interfaces/dynamic-portal";

export class TabData {
  constructor(public tabTitle: string,
              public contentTitle: string,
              public iconClass: string,
              public service: DynamicPortal) {
  }
}

export class TabConfig {
  static createTwitterWithService(service: DynamicPortal): TabData {
    return new TabData("Twitter", "Rest Clover", "fab fa-twitter-square", service);
  }

  static createLinkedInWithService(service: DynamicPortal): TabData {
    return new TabData("LinkedIn", "Selenium Clover", "fab fa-linkedin", service);
  }

}
