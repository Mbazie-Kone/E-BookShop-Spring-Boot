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
  person: any;
  isProfile: boolean;

  constructor(private contactsService: ContactsServiceService, private route: ActivatedRoute){}

  ngOnInit(): void {
    if(this.route.snapshot.paramMap.get('id')) {
      this.isProfile = true;
      this.person = this.contactsService.getPerson(parseInt(this.route.snapshot.paramMap.get('id')!));
    }
    else {
      this.isProfile = false;
      this.people = this.contactsService.getPeople(); 
    }
    // console.log(this.route.snapshot.paramMap.get('id'));
    // console.log(this.isProfile);
  }

}