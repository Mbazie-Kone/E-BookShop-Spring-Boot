import { Component, OnInit } from '@angular/core';

import myAppConfig from '../../config/my-app-config';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  oktaSignin: any;

  constructor() {}

  ngOnInit(): void {
    
  }
}
