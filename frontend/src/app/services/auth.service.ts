import { Injectable, OnDestroy } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, tap, of, map, catchError, Subscription } from 'rxjs';

import { environment } from '../../environments/environment';
import { LoginViewModel } from '../interfaces/LoginViewModel';
import { UserViewModel } from '../interfaces/UserViewModel';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Injectable({providedIn: 'root'})
export class AuthService implements OnDestroy {
  isError:boolean=false;
  private API_URL = environment.API_URL + 'auth/login';
  private user?: UserViewModel;
  subs:Subscription=new Subscription();
  private logoutCalled: boolean = false;


  constructor(private http: HttpClient, private toastr: ToastrService,
    private router: Router,
  ) {
    this.init()
  }

  ngOnDestroy(): void {
    this.subs?.unsubscribe();
  }

  get currentUser():UserViewModel|undefined {
    if ( !this.user ) return undefined;
    return structuredClone( this.user );
  }

  login( entity:LoginViewModel):Observable<UserViewModel> {
    // http.post('login',{ email, password });
    const url = `${this.API_URL}`;


      return this.http.post<UserViewModel>(url,entity)
        .pipe(
          tap( user => localStorage.setItem('token', user.token )),
          map((res: UserViewModel) => {
            localStorage.setItem('user', JSON.stringify(res));

            this.toastr.success("Exito! La sesión se inició correctamente")

            this.router.navigate(['/']);
            this.isError=false;
            return res
          }),
          catchError(e => {
            this.isError=false;
            this.toastr.error("El usuario o contraseña son incorectos")
            this.isError=true;
            return of(null);
          })
          );

  }

  checkAuthentication(): Observable<boolean> {


    return of(!!localStorage.getItem('token') || !!localStorage.getItem('user'));


  }


  public logout() {
    //if(this.logoutCalled)return;
    console.log("SALIR")
    this.user = undefined;
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    this.router.navigate(['/auth']);
    this.logoutCalled=true;
    //this.subs?.unsubscribe();
  }


  get userCurrent(){
    // Obtener la cadena JSON del localStorage
    const userJson = localStorage.getItem('user');

    if (userJson) {
      // Convertir la cadena JSON de nuevo a un objeto
      const user = JSON.parse(userJson);
      this.user=user["usuario"];
    }else{
      localStorage.removeItem("token");
      //this.logout()
    }

    return this.user;
  }

  init(){
    const userJson = localStorage.getItem('user');
    if (userJson) {
          // Convertir la cadena JSON de nuevo a un objeto
          const user = JSON.parse(userJson);
          this.user=user["usuario"];
      }else{
          this.logout()
    }
  }

}
