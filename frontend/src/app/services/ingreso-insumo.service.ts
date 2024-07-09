import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';
import { map } from 'rxjs';
import { IngresoInsumoCreateViewModel } from '../interfaces/IngresoInsumoCreateViewModel';
import { IngresoInsumoViewModel } from '../interfaces/IngresoInsumoViewModel';

@Injectable()
export class IngresoInsumoService {
  private API_URL =environment.API_URL + 'ingresoInsumo' ;

  constructor(private http: HttpClient,private toastr: ToastrService) { }

  delete(id:number){
    const url = `${this.API_URL}/${id}`;
    return this.http.delete<any>(url)
      .pipe(
        map((res: any) => {
          this.toastr.success("Exito! Se elimino el ingreso del insumo ")

          return res
        })
      );
  }

  post(entity:IngresoInsumoCreateViewModel){
    const url = `${this.API_URL}`;
    return this.http.post<any>(url,entity)
      .pipe(
        map((res: any) => {
          this.toastr.success("Exito! se registro un nuevo ingreso ")

         return res;
        })
      );
  }

  getById(id:number){
    const url = `${this.API_URL}/${id}`;
    return this.http.get<IngresoInsumoViewModel>(url)
    .pipe(
      map((res: IngresoInsumoViewModel) => {
        return res
      })
      );
  }

  putEdit(id:number,entity:IngresoInsumoCreateViewModel){
    const url = `${this.API_URL}/${id}`;
    return this.http.put<any>(url,entity)
      .pipe(
        map((res: any) => {
          this.toastr.success("Exito! se modifico el registro ")

         return res;
        })
      );
  }
}
