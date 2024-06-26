import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent implements OnInit {

  constructor(private route: Router) {

  }

  ngOnInit(): void {
    
  }

  doSearch(value: string) {
    console.log(`value=${value}`);
    this.route.navigateByUrl(`/search/${value}`);
  }

}
