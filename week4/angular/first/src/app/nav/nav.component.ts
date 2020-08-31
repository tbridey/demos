import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  public url: string = "https://google.com";
  public location: string = "Google";
  public myVar: any = 55;

  constructor() { }

  ngOnInit(): void {
  }
}
