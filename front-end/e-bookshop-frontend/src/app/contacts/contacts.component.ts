import { Component, OnInit } from '@angular/core';
import { ContactsServiceService } from '../contacts-service.service';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrl: './contacts.component.css'
})
export class ContactsComponent implements OnInit {

  people: any;
  person: any;

  constructor(private contactsService: ContactsServiceService){}

  ngOnInit(): void {
    this.people = this.contactsService.getPeople(); 
    // console.log(this.route.snapshot.paramMap.get('id'));
    // console.log(this.isProfile);
  }

}