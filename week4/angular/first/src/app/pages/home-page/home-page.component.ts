import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public currentUser: any = undefined;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.currentUser = sessionStorage.getItem("currentUser");
  }

  logout(): void {
    // Also needs to be refactored
    sessionStorage.removeItem("currentUser");
    // Effectively log out the User
    // Navigate back to login page
    this.router.navigateByUrl("/login");

    // this.router.navigate(['/home', 5]);
    // The navigate method allows us to inject Path Variables
  }
}
