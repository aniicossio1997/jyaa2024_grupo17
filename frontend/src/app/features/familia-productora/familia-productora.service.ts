import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { NameableViewModel } from '../../interfaces/NameableViewModel';
import { FamiliaProductoraViewModel } from '../../interfaces/FamiliaProductoraViewModel';
import { environment } from '../../../environments/environment';

@Injectable()
export class FamiliaProductoraService implements OnDestroy{

  private API_URL =environment.API_URL+'familiaProductoras' ;


  constructor(private http: HttpClient,  private toastr: ToastrService) { }

  get(){
    const url = `${this.API_URL}`;
    return this.http.get<FamiliaProductoraViewModel[]>(url)
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

  putFamilia(id:number,entity: any): Observable<any> {
    const url = `${this.API_URL}/${id}`;
    return this.http.put<any[]>(url, entity).pipe(
      map((res: any) => {
        this.toastr.success("Se ha editado la familia productora");
        return res;
      }),
      catchError(e => {
        this.toastr.error("No se ha podido editar la familia productora ")
        return of([]);
      })
    );
  }
  getById(id:number){
    const url = `${this.API_URL}/${id}`;
    return this.http.get<FamiliaProductoraViewModel>(url)
      .pipe(
        map((res: any) => res)
        );
  }

  delete(id:number): Observable<any> {
    const url = `${this.API_URL}/${id}`;
    return this.http.delete(url).pipe(
      map((res: any) => {
        this.toastr.success("Se ha eliminado exitosamente la familia productora");
        return res;
      }),
      catchError(e => {
        this.toastr.error("No se ha podido Eliminar la familia productora ")
        return of([]);
      })
    );
  }

  ngOnDestroy(): void {

  }
}
