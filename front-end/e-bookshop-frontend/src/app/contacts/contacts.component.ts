import { Component, OnInit } from '@angular/core';
import { ContactsServiceService } from '../contacts-service.service';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrl: './contacts.component.css'
})
export class ContactsComponent implements OnInit {

  people: any;

  constructor(private contactsService: ContactsServiceService){}

  ngOnInit(): void {
   this.contactsService.getPeople();
  }

}
