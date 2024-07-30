import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanMatch, Route, UrlSegment, UrlTree, RouterStateSnapshot, Router } from '@angular/router';
import { Observable, of, take, tap } from 'rxjs';
import { AuthService } from '../../services/auth.service';
import { ManagementRoutes } from '../../routers';


@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements  CanActivate, CanMatch {


  constructor(
    private authService: AuthService,
    private router: Router,
  ) { }

  private checkAuthStatus(): boolean | Observable<boolean> {
    return this.authService.checkAuthentication()
      .pipe(
        take(1),
        tap( isAuthenticated => console.log('Authenticated:', isAuthenticated ) ),
        tap( isAuthenticated => {
          if ( !isAuthenticated ) {
            this.router.navigate(['/' + ManagementRoutes.Auth]);
          }
        }),

      )

  }

  canMatch(route: Route, segments: UrlSegment[]): boolean | Observable<boolean> {
     return this.checkAuthStatus();
   }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> {
    console.log({ route, state })

    return this.checkAuthStatus();
  }

}
