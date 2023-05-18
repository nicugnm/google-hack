import {AuthComponent} from "./auth/auth.component";
import {Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {HomeComponent} from "./home/home.component";
import {AuthGuard} from "./interceptors/auth-guard";

const routes : Routes = [
  { path: 'auth', component: AuthComponent, pathMatch: 'full' },
  { path: '', redirectTo: 'auth', pathMatch: 'full' },
  { path: 'authorized', redirectTo: 'auth', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, pathMatch: 'full', canActivate: [AuthGuard] },
  { path: 'home', component: HomeComponent, pathMatch: 'full'}
]

export default routes;
