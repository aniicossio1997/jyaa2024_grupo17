import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { catchError, Observable, throwError } from "rxjs";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private router: Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('token'); // O el método que utilices para obtener el token

    console.log("AUTH::")
    if (token) {
      const clonedRequest = req.clone({
        headers: req.headers.set('Authorization', `Bearer ${token}`)
      });
      return next.handle(clonedRequest).pipe(
        catchError((error: HttpErrorResponse) => {
          if (error.status === 401) {
            // Borra el localStorage y redirige al login
            localStorage.removeItem('token');
            localStorage.removeItem('user');
            this.router.navigate(['/auth']);
          }
          return throwError(() => error);
        })
      );
    } else {
      return next.handle(req).pipe(
        catchError((error: HttpErrorResponse) => {
          if (error.status === 401) {
            // Borra el localStorage y redirige al login
            localStorage.removeItem('token');
            localStorage.removeItem('user');
            this.router.navigate(['/auth']);
          }
          return throwError(() => error);
        })
      );
    }
  }
}
