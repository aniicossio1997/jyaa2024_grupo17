import { Injectable, OnDestroy } from '@angular/core';
import { CanMatch, CanActivate, Router, Route, UrlSegment, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable, tap, map, of, Subscription, take } from 'rxjs';
import { AuthService } from '../../services/auth.service';


@Injectable({providedIn: 'root'})
export class PublicGuard implements  CanActivate, OnDestroy {

  subs:Subscription=new Subscription();

  constructor(
    private authService: AuthService,
    private router: Router,
  ) { }

  ngOnDestroy(): void {
    throw new Error('[ERROR::] Method not implemented.');
  }

  private checkAuthStatus(): boolean | Observable<boolean> {


    return this.authService.checkAuthentication()
      .pipe(
        take(1),
        tap( isAuthenticated => console.log('Authenticated:', isAuthenticated ) ),
        tap( isAuthenticated => {
          if ( isAuthenticated ) {
            //console.log("REDIRECT", "SE LOGUEO")
            this.router.navigate(['/usuarios'])
          }
        }),
        map( isAuthenticated => !isAuthenticated )
      )

  }


  // canMatch(route: Route, segments: UrlSegment[]): boolean | Observable<boolean> {
  //   return this.checkAuthStatus();
  // }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> {
    // console.log('Can Activate');
    console.log({ route, state, }, "canActivate")

    return this.checkAuthStatus();
  }

}
