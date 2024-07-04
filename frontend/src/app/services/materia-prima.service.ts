import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, of } from 'rxjs';
import { MateriaPrimaCreateViewModel } from '../interfaces/MateriaPrimaCreateViewModel';
import { MateriaPrimaDetailViewModel } from '../interfaces/MateriaPrimaDetailViewModel';
import { MateriaPrimaViewModel } from '../interfaces/MateriaPrimaViewModel';
import { ToastrService } from 'ngx-toastr';
import { environment } from '../../environments/environment';

@Injectable()
export class MateriaPrimaService {
  private API_URL =environment.API_URL + 'materiaPrimas' ;


  constructor(private http: HttpClient,  private toastr: ToastrService) { }

  get(){
    const url = `${this.API_URL}`;
    return this.http.get<MateriaPrimaViewModel[]>(url)
      .pipe(
        map((res: MateriaPrimaViewModel[]) => res)
        );
  }

  post(entity:MateriaPrimaCreateViewModel){
    const url = `${this.API_URL}`;
    return this.http.post<any>(url,entity)
      .pipe(
        map((res: any) => {
          this.toastr.success("Exito! se ha podido guardar la materia prima ")

          return res
        }),
        catchError(e => {
          this.toastr.error("No se ha podido guardar la materia prima ")
          return of([]);
        })
        );
  }
  getById(id:number){
    const url = `${this.API_URL}/${id}`;
    return this.http.get<MateriaPrimaDetailViewModel>(url)
      .pipe(
        map((res: MateriaPrimaDetailViewModel) => {
          return res
        })
        );
  }
  put(id:number,entity:MateriaPrimaCreateViewModel){
    const url = `${this.API_URL}/${id}`;
    return this.http.put<MateriaPrimaViewModel>(url,entity)
      .pipe(
        map((res: MateriaPrimaViewModel) => {
          this.toastr.success("Exito! se han guardado los cambios ")

          return res
        })
      );
  }
}
