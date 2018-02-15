import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Observable} from 'rxjs/Observable';

import {Religion} from './religion';
import {of} from 'rxjs/observable/of';
import {catchError, tap} from 'rxjs/operators';

@Injectable()
export class ReligionService {

  private religionsUrl = 'http://localhost:8080/api/religions';

  constructor(private http: HttpClient) {
  }

  getReligions(): Observable<Religion[]> {
    return this.http.get<Religion[]>(this.religionsUrl)
      .pipe(
        tap(religions => console.log(`fetched religions`)),
        catchError(this.handleError('getReligions', []))
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
