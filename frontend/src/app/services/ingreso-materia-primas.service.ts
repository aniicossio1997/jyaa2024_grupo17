import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IngresoMateriaPrimaCreateViewModel } from '../interfaces/ingresoMateriaPrimaCreate';
import { map } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { environment } from '../../environments/environment';

@Injectable()
export class IngresoMateriaPrimasService {
  private API_URL =environment.API_URL + 'ingresoMateriaPrima' ;


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
