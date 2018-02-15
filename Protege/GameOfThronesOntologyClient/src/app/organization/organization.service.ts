import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Observable} from 'rxjs/Observable';

import {Organization} from './organization';
import {of} from 'rxjs/observable/of';
import {catchError, tap} from 'rxjs/operators';

@Injectable()
export class OrganizationService {

  private organizationsUrl = 'http://localhost:8080/api/organizations';

  constructor(private http: HttpClient) {
  }

  getOrganizations(): Observable<Organization[]> {
    return this.http.get<Organization[]>(this.organizationsUrl)
      .pipe(
        tap(organizations => console.log(`fetched organizations`)),
        catchError(this.handleError('getOrganizations', []))
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
