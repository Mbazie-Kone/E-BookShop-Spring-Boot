import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
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
    this.route.paramMap.subscribe((params: ParamMap)=>{
      this.id = +params.get('id')!;
      this.person = this.contactService.getPerson(this.id);
    })  
  }
}