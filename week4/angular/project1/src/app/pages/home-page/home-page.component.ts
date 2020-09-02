import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public currentUser: Employee = undefined;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
  }

  logout(): void {
    // Also needs to be refactored
    sessionStorage.removeItem("currentUser");
    // Effectively log out the User
    // Navigate back to login page
    this.router.navigateByUrl("/login");
  }
}
