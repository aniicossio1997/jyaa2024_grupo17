import { Injectable, OnDestroy } from '@angular/core';
import { Observable, Subscription, of } from 'rxjs';
import { Router } from '@angular/router';
import { UserViewModel } from '../interfaces/UserViewModel';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthFacade implements OnDestroy {
  private user?: UserViewModel;
  private logoutCalled: boolean = false;
  private subs: Subscription = new Subscription();

  constructor(
    private authService: AuthService,
    private router: Router,
  ) {
    this.init();
  }

  ngOnDestroy(): void {
    this.subs?.unsubscribe();
  }



  checkAuthentication(): Observable<boolean> {
    return this.authService.checkAuthentication();
  }

  logout(): void {
    if (this.logoutCalled) return;

    this.logoutCalled = true;
    console.log("SALIR");
    this.user = undefined;
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    this.router.navigate(['/auth']);
  }

  get userCurrent(): UserViewModel | undefined {
    const userJson = localStorage.getItem('user');
    if (userJson) {
      const user = JSON.parse(userJson);
      this.user = user["usuario"];
    } else {
      this.logout();
    }
    return this.user;
  }

  private init(): void {
    const userJson = localStorage.getItem('user');
    if (userJson) {
      const user = JSON.parse(userJson);
      this.user = user["usuario"];
    } else {
      this.logout();
    }
  }
}
