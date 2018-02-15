import {Component, OnInit} from '@angular/core';

import {Family} from './family';
import {FamilyService} from './family.service';

@Component({
  selector: 'app-families',
  templateUrl: './families.component.html',
  styleUrls: ['./families.component.css']
})
export class FamiliesComponent implements OnInit {

  selectedFamily: Family;
  families: Family[];

  constructor(private familyService: FamilyService) {
  }

  onSelect(family: Family): void {
    this.selectedFamily = family;
  }

  getFamilies(): void {
    this.familyService.getFamilies()
      .subscribe(families => this.families = families);
  }

  ngOnInit() {
    this.getFamilies();
  }
}
