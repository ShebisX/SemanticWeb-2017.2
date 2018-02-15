import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Observable} from 'rxjs/Observable';

import {Family} from './family';
import {of} from 'rxjs/observable/of';
import {catchError, tap} from 'rxjs/operators';

@Injectable()
export class FamilyService {

  private familiesUrl = 'http://localhost:8080/api/families';

  constructor(private http: HttpClient) {
  }

  getFamilies(): Observable<Family[]> {
    return this.http.get<Family[]>(this.familiesUrl)
      .pipe(
        tap(families => console.log(`fetched families`)),
        catchError(this.handleError('getFamilies', []))
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
