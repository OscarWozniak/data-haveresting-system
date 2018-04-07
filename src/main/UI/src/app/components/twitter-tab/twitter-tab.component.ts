import {Component, OnInit} from "@angular/core";
import {TwitterModel} from "../../shared/classes/Twitter.model";
import {ICloverable} from "../../interfaces/Cloverable.interface";
import {TwitterService} from "../../services/twitter/twitter.service";

@Component({
  selector: 'app-twitter-tab',
  templateUrl: './twitter-tab.component.html',
  styleUrls: ['./twitter-tab.component.scss']
})
export class TwitterTabComponent implements OnInit, ICloverable {
  private model = new TwitterModel();

  constructor(private service: TwitterService) {
  }

  doClover(): void {
    this.service.doClover(this.model);
  }

  ngOnInit() {
  }

}
