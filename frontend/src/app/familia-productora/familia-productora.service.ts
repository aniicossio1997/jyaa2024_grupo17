import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
import { NameableViewModel } from '../interfaces/NameableViewModel';
import { FamialiProductoraCreateViewModel } from '../interfaces/FamiliaProductoraCreateViewModel';
import { ToastrService } from 'ngx-toastr';

@Injectable()
export class FamiliaProductoraService implements OnDestroy{

  private API_URL ='http://localhost:8080/SalaDeElaboracion/api/familiaProductoras' ;


  constructor(private http: HttpClient,  private toastr: ToastrService) { }

  get(){
    const url = `${this.API_URL}`;
    return this.http.get<NameableViewModel[]>(url)
      .pipe(
        map((res: any) => res)
        );
  }

  post(entity: any): Observable<any> {
    const url = `${this.API_URL}`;
    return this.http.post<any[]>(url, entity).pipe(
      map((res: any) => {
        this.toastr.success("Se ha agregado una nueva familia");
        return res;
      }),
      catchError(e => {
        this.toastr.error("No se ha podido guardar la familia productora ")
        return of([]);
      })
    );
  }

  ngOnDestroy(): void {

  }
}
