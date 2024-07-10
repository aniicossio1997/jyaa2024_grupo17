import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { ToastrService } from 'ngx-toastr';
import { HttpClient } from '@angular/common/http';
import { EstadoIngresoMateriaViewModel } from '../interfaces/EstadoIngresoMateriaViewModel';
import { catchError, map, of } from 'rxjs';

@Injectable()
export class EstadoIngresoMateriaPrimaService {

  private API_URL =environment.API_URL + 'estadoIngresoMateriaPrima' ;


  constructor(private http: HttpClient,private toastr: ToastrService) { }

  post(id:number,entity:EstadoIngresoMateriaViewModel){
    const url = `${this.API_URL}`;
    return this.http.post<any>(url,entity)
      .pipe(
        map((res: any) => {
          this.toastr.success("Exito! agrego nuevo estado ")

         return res;
        }),
        catchError((e) => {
          this.toastr.error('No se ha podido guardar el estado nuevo');
          return of([]);
        })
      );
  }
}
