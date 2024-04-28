import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ContactsServiceService } from '../contacts-service.service';

@Component({
  selector: 'app-single-contacts',
  templateUrl: './single-contacts.component.html',
  styleUrl: './single-contacts.component.css'
})
export class SingleContactsComponent implements OnInit {
  id: number;
  person: any;

  constructor(private route: ActivatedRoute, private contactService: ContactsServiceService) {}

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!
    if(this.route.snapshot.paramMap.get('id')) {
      this.person = this.contactService.getPerson(this.id);
    }
  }
}