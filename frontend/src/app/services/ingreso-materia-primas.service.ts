import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IngresoMateriaPrimaCreateViewModel } from '../interfaces/ingresoMateriaPrimaCreate';
import { map } from 'rxjs';
import { ToastrService } from 'ngx-toastr';

@Injectable()
export class IngresoMateriaPrimasService {
  private API_URL ='http://localhost:8080/SalaDeElaboracion/api/materiaPrimas' ;


  constructor(private http: HttpClient,private toastr: ToastrService) { }

  post(entity:IngresoMateriaPrimaCreateViewModel){
    const url = `${this.API_URL}`;
    return this.http.post<any>(url,entity)
      .pipe(
        map((res: any) => {
          this.toastr.success("Exito! se ha agregado un nuevo ingreso ")

         return res;
        })
      );
  }

}
