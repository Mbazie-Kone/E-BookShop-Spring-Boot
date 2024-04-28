import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContactsServiceService {

  people = [
    {name: "Mark", surname: "Lewandowski", email: "m.l@gmail.org"},
    {name: "Sara", surname: "Viola", email: "sara.viola@live.org"},
    {name: "Peter", surname: "Red", email: "p.r@gmail.com"},
    {name: "Issa", surname: "Gueye", email: "issa.g@gmail.fr"},
  ]
  constructor() {
  }

  getPeople() {
    return this.people;
  }

  getPerson(index: number) {
    return this.people[index];
  }
}
