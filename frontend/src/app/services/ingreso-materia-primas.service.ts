import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IngresoMateriaPrimaCreateViewModel } from '../interfaces/ingresoMateriaPrimaCreate';
import { map } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { environment } from '../../environments/environment';
import { IngresoMateriaPrimaDetailViewModel } from '../interfaces/IngresoMateriaPrimaDetailViewModel';

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
  getById(id:number){
    const url = `${this.API_URL}/${id}`;
    return this.http.get<IngresoMateriaPrimaDetailViewModel>(url)
    .pipe(
      map((res: IngresoMateriaPrimaDetailViewModel) => {
        return res
      })
      );
  }

  delete(id:number){
    const url = `${this.API_URL}/${id}`;
    return this.http.delete<IngresoMateriaPrimaDetailViewModel>(url)
      .pipe(
        map((res: IngresoMateriaPrimaDetailViewModel) => {
          this.toastr.success("Exito! Se elimino el ingreso de la materia prima ")

          return res
        })
      );
  }
  put(id:number,entity:IngresoMateriaPrimaCreateViewModel){
    const url = `${this.API_URL}/${id}`;
    return this.http.put<any>(url,entity)
      .pipe(
        map((res: any) => {
          this.toastr.success("Exito! se ha Editado el ingreso con código " + entity.codigo)

         return res;
        })
      );
  }

}
