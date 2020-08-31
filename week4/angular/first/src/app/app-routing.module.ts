import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';

/**
 * The first route found, will be the one used
 * If there are conflicts, the order they are declared
 * is important
 */
const routes: Routes = [
  { path: "login", component: LoginPageComponent },
  { path: "home", component: HomePageComponent },
  { path: "**", redirectTo: "login", pathMatch: 'full' }
  /**
   * The last route can be a sort of "catch all"
   * route, and redirect us to some default component
   */
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
