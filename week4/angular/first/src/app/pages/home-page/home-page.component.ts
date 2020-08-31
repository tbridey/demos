import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public currentUser: any = undefined;

  constructor() { }

  ngOnInit(): void {
    this.currentUser = sessionStorage.getItem("currentUser");
  }

  goback(): void {
    // Also needs to be refactored
    window.history.back();
  }
}
