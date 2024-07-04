import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EbookshopFormServiceService {

  constructor() { }

  getCreditCardMonths(startMonth: number): Observable<number[]> {
    let data: number[] = [];
    // build an array for "Month" dropdown list
    // - start at current month and loop until
    for(let theMonth = startMonth; theMonth <= 12; theMonth++) {
      data.push(theMonth);
    }
    return of(data);
  }

  getCreditCardYears(startMonth: number): Observable<number[]> {
    let data: number[] = [];
    // build an array for "Year" downlist list
    // - start at current year and loop for next 10 years
    const startYear: number = new Date().getFullYear();
    return of(data);
  }
}
