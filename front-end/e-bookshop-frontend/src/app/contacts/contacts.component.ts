import { Component, OnInit } from '@angular/core';
import { ContactsServiceService } from '../contacts-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrl: './contacts.component.css'
})
export class ContactsComponent implements OnInit {

  people: any;
  isProfile: boolean;

  constructor(private contactsService: ContactsServiceService, private route: ActivatedRoute){}

  ngOnInit(): void {
    this.people = this.contactsService.getPeople();
    this.isProfile = !this.route.snapshot.paramMap.get('id') ? false : true;
    console.log(this.route.snapshot.paramMap.get('id'));
    console.log(this.isProfile);
  }

}
