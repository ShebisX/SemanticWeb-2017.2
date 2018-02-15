import {Component, OnInit} from '@angular/core';

import {Organization} from './organization';
import {OrganizationService} from './organization.service';

@Component({
  selector: 'app-organizations',
  templateUrl: './organizations.component.html',
  styleUrls: ['./organizations.component.css']
})
export class OrganizationsComponent implements OnInit {

  selectedOrganization: Organization;
  organizations: Organization[];

  constructor(private organizationService: OrganizationService) {
  }

  onSelect(organization: Organization): void {
    this.selectedOrganization = organization;
  }

  getOrganizations(): void {
    this.organizationService.getOrganizations()
      .subscribe(organizations => this.organizations = organizations);
  }

  ngOnInit() {
    this.getOrganizations();
  }
}
