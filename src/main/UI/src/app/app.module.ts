import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {TabComponent} from './components/tab/tab.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {HttpModule} from "@angular/http";
import {CroverableWebsiteComponent} from './components/croverable-website/croverable-website.component';
import {HistoryListComponent} from './components/history-list/history-list.component';
import {HistoryLogComponent} from './components/history-log/history-log.component';
import {UserTableComponent} from './components/user-table/user-table.component';
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component';
import {APP_ROUTES} from "./routes";
import {MaterialModule} from "./material.module";
import {DynamicLinkedInService} from "./services/dynamic-linkedIn/dynamic-linked-in.service";
import {DynamicTwitterService} from "./services/dynamic-twitter/dynamic-twitter.service";
import { TwitterTabComponent } from './components/twitter-tab/twitter-tab.component';
import { LinkedInTabComponent } from './components/linked-in-tab/linked-in-tab.component';

@NgModule({
  declarations: [
    AppComponent,
    TabComponent,
    CroverableWebsiteComponent,
    HistoryListComponent,
    HistoryLogComponent,
    UserTableComponent,
    PageNotFoundComponent,
    TwitterTabComponent,
    LinkedInTabComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    MaterialModule,
    ReactiveFormsModule,
    APP_ROUTES
  ],
  providers: [DynamicLinkedInService, DynamicTwitterService],
  bootstrap: [AppComponent]
})
export class AppModule {
}