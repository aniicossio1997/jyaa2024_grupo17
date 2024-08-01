import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { NameableViewModel } from '../../interfaces/NameableViewModel';
import { FamiliaProductoraViewModel } from '../../interfaces/FamiliaProductoraViewModel';
import { environment } from '../../../environments/environment';
import { PuntoVentaViewModel } from '../../interfaces/PuntoVentaViewModel';
import PuntoVentaCreateViewModel from '../../interfaces/PuntoVentaCreateViewModel';

@Injectable()
export class PuntoVentaService implements OnDestroy{

  private API_URL =environment.API_URL+'puntosventa' ;


  constructor(private http: HttpClient,  private toastr: ToastrService) { }

  get(){
    const url = `${this.API_URL}`;
    return this.http.get<PuntoVentaViewModel[]>(url)
      .pipe(
        map((res: any) => res)
        );
  }

  post(entity: PuntoVentaCreateViewModel): Observable<any> {
    const url = `${this.API_URL}`;
    return this.http.post<PuntoVentaViewModel[]>(url, entity).pipe(
      map((res: any) => {
        this.toastr.success("Se ha agregado el punto de venta!");
        return res;
      }),
      catchError(e => {
        this.toastr.error("No se ha podido guardar el punto de venta")
        return of([]);
      })
    );
  }

  update(id:number,entity: any): Observable<any> {
    const url = `${this.API_URL}/${id}`;
    return this.http.put<PuntoVentaViewModel[]>(url, entity).pipe(
      map((res: any) => {
        this.toastr.success("Se ha editado el punto de venta!");
        return res;
      }),
      catchError(e => {
        this.toastr.error("No se ha podido editar el punto de venta")
        return of([]);
      })
    );
  }

  getById(id:number){
    const url = `${this.API_URL}/${id}`;
    return this.http.get<PuntoVentaViewModel>(url)
  }

  delete(id:number): Observable<any> {
    const url = `${this.API_URL}/${id}`;
    return this.http.delete(url).pipe(
      map((res: any) => {
        this.toastr.success("Se ha eliminado exitosamente el punto de venta");
        return res;
      }),
      catchError(e => {
        this.toastr.error("No se ha podido eliminar el punto de venta")
        return of([]);
      })
    );
  }

  ngOnDestroy(): void {

  }
}
