import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-single-contacts',
  templateUrl: './single-contacts.component.html',
  styleUrl: './single-contacts.component.css'
})
export class SingleContactsComponent implements OnInit {

  @Input() person: any;

  constructor(){}

  ngOnInit(): void {
    
  }
}