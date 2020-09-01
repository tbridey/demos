import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';

/*
 * Angular uses the TypeScript's decorators
 * to define its overall structures/schematics
 *
 * Angular has 3 primary schematics:
 *    Components
 *    Modules
 *    Services
 *
 * Components
 *    Components combine together: .ts, .html, and .css files
 *    Uses the @Component decorator
 *
 *    These 3 files contribute to an overal "portion of a webpage"
 *    Specifically, there is a "view" and "logic", to control the view
 *
 * Services
 *    Are just isolated .ts files
 *    They have no "view" associated with them
 *
 *    Generally, if there is some set of logic/instructions that is not
 *    necessarily associated with a view, and most importantly, can be reused
 *    across different views, we can use a service
 *
 *    Components can use services
 *
 *    Uses the @Injectible decorator
 *
 * Modules
 *    Modules are high level organizational structure
 *    Modules contain Components and Services
 *    Modules can import other Modules
 *
 *    Generally, they are used to organize our applications
 *    and follow abstraction, so that we can reduce cognitive complexity
 *    (The idea that each unit/section "appears" simple, but is in fact complex)
 *
 *    Modules do have some very useful "lazy-loading" features
 *
 *    Uses the @NgModule decorator
 *
 *
 * There are miscellaneous smaller structures/schematics
 *    such as Pipes
 *    Uses @Pipe decorator
 */
@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  public username: string = "";
  public password: string = "";

  /**
   * Angular will perform Dependency Injection
   *
   * This means that Angular will automatically instantiate
   * an instance of my parameter, and inject it into the constructor
   * when this Component is being created
   *
   * We no longer need to invoke the constructor of our parameters
   * manually.
   *
   * It is all performed behind the scenes for us.
   */
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
  }

  /**
   * There are 4 types of databinding in Angular
   *
   * String Interpolation
   *    Uses {{ }} syntax
   *    Is used to inject data into .html from .ts, specifically for innerHTML usage
   * Property/Attribute Binding
   *    Uses [] syntax
   *    Is used to inject data into .html from .ts, specifically for values of attributes
   * Event Binding
   *    Uses () syntax
   *    Is used to execute functionality in .ts from events in .html for responding to
   *      user input/actions
   * Two-Way DataBinding
   *    Uses [(ngModel)] syntax
   *        Refer to this as "banana in a box" syntax to help remember
   *        But don't say that in QC
   *    Pulls data from an input field that the user entered information into
   *        and stores it in a variable in the .ts, which can then be used to
   *        further inject back into the .html with {{ }} or []
   *    Only works for <input> tags
   *
   * All databinding is moving information back and forth between .html and .ts
   */

  async sendLogin(): Promise<void> {
    try {
      // Fetch statement can also be refactored
      // let response = await fetch("http://localhost:8080/ServletDemo/login?" +
      //   "username=" + this.username + "&password=" + this.password);

      // sessionStorage.setItem("currentUser", await response.json());

      // let responseObservable = this.http.get<string>('http://localhost:8080/ServletDemo/login', {
      //   params: {
      //     username: this.username,
      //     password: this.password
      //   }
      // });

      // responseObservable.subscribe( (str) => {
      //   sessionStorage.setItem("currentUser", str);
      // });

      let username = await this.http.get<string>('http://localhost:8080/ServletDemo/login', {
        params: {
          username: this.username,
          password: this.password
        }
      }).toPromise();

      sessionStorage.setItem("currentUser", username);

      // responseObservable.

      // Navigate to home page
      // Refactor later
      // window.location.href = environment.baseUrl + "home";
      this.router.navigateByUrl("/home");
    } catch(error) {
      // Failed to login
      console.log(error);
      alert("Failed to login");
    }
  }
}
