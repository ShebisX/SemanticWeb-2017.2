import {Component, OnInit} from '@angular/core';

import {Person} from './person';
import {PersonService} from './person.service';

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {

  selectedPerson: Person;
  persons: Person[];

  constructor(private personService: PersonService) {
  }

  onSelect(person: Person): void {
    this.selectedPerson = person;
  }

  getPersons(): void {
    this.personService.getPersons()
      .subscribe(persons => this.persons = persons);
  }

  ngOnInit() {
    this.getPersons();
  }
}
