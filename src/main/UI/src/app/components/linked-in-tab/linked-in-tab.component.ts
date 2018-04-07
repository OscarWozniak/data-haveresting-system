import {Component, OnInit} from '@angular/core';
import {LinkedInModel} from "../../shared/classes/LinkedIn.model";
import {ICloverable} from "../../interfaces/Cloverable.interface";
import {LinkedInService} from "../../services/linkedIn/linked-in.service";

@Component({
  selector: 'app-linked-in-tab',
  templateUrl: './linked-in-tab.component.html',
  styleUrls: ['./linked-in-tab.component.scss']
})
export class LinkedInTabComponent implements OnInit, ICloverable {

  private model: LinkedInModel;

  constructor(private service: LinkedInService) {
    this.model = new LinkedInModel();
  }

  doClover() {
    this.service.doClover(this.model);
  }

  ngOnInit() {
  }

}
