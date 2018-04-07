import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";
import {RouterModule, Routes} from "@angular/router";
import {TabComponent} from "./components/tab/tab.component";
import {UserTableComponent} from "./components/user-table/user-table.component";

const routes: Routes = [
  {path: '', component: TabComponent},
  {path: 'user', component: UserTableComponent},
  {path: '**', component: PageNotFoundComponent}
];

const config = {enableTracing: true};

export const APP_ROUTES = RouterModule.forRoot(routes, config);



/*
* doClover + type
* getHistory + type
* removeHistoryLog + id
* viewHistoryLog + id
* */


/*
* Icons for tabs
* trash ico on the right
* table configuration / Component
* tabs css
*
* */
