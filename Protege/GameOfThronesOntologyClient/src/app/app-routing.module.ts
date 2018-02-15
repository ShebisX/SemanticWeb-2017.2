import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {PersonsComponent} from './person/persons.component';
import {FamiliesComponent} from './family/families.component';
import {ReligionsComponent} from './religion/religions.component';
import {OrganizationsComponent} from './organization/organizations.component';
import {DashboardComponent} from './dashboard/dashboard.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full',
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
  },
  {
    path: 'persons',
    component: PersonsComponent,
  },
  {
    path: 'families',
    component: FamiliesComponent,
  },
  {
    path: 'religions',
    component: ReligionsComponent,
  },
  {
    path: 'organizations',
    component: OrganizationsComponent,
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule,
  ]
})
export class AppRoutingModule {
}
