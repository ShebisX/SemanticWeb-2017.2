import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {FormsModule} from '@angular/forms'; // NgModule

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
// Dashboard
import { OrganizationsComponent } from './organization/organizations.component';
import { ReligionsComponent } from './religion/religions.component';
import { FamiliesComponent } from './family/families.component';
import { PersonsComponent } from './person/persons.component';
import {PersonService} from './person/person.service';
import {DashboardComponent} from './dashboard/dashboard.component';
import {OrganizationService} from './organization/organization.service';
import {ReligionService} from './religion/religion.service';
import {FamilyService} from './family/family.service';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    OrganizationsComponent,
    ReligionsComponent,
    FamiliesComponent,
    PersonsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [
    OrganizationService,
    ReligionService,
    FamilyService,
    PersonService,
  ],
  bootstrap: [
    AppComponent,
  ]
})
export class AppModule {
}
