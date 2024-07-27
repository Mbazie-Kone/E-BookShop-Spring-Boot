import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
  
  }

  onLogin() {
    this.authService.login(this.username, this.password).subscribe(
      response => {
        if(response) {
          this.router.navigate(['/products']);
        }
        else {
          alert('Invalid credentials');
        }
      });
  }
}