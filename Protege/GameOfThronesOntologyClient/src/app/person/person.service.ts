import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Observable} from 'rxjs/Observable';

import {Person} from './person';
import {of} from 'rxjs/observable/of';
import {catchError, tap} from 'rxjs/operators';

@Injectable()
export class PersonService {

  private personsUrl = 'http://localhost:8080/api/persons';

  constructor(private http: HttpClient) {
  }

  getPersons(): Observable<Person[]> {
    return this.http.get<Person[]>(this.personsUrl)
      .pipe(
        tap(persons => console.log(`fetched persons`)),
        catchError(this.handleError('getPersons', []))
      );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
