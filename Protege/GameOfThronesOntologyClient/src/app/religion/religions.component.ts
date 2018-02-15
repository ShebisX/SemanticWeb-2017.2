import {Component, OnInit} from '@angular/core';

import {Religion} from './religion';
import {ReligionService} from './religion.service';

@Component({
  selector: 'app-religions',
  templateUrl: './religions.component.html',
  styleUrls: ['./religions.component.css']
})
export class ReligionsComponent implements OnInit {

  selectedReligion: Religion;
  religions: Religion[];

  constructor(private religionService: ReligionService) {
  }

  onSelect(religion: Religion): void {
    this.selectedReligion = religion;
  }

  getReligions(): void {
    this.religionService.getReligions()
      .subscribe(religions => this.religions = religions);
  }

  ngOnInit() {
    this.getReligions();
  }
}
