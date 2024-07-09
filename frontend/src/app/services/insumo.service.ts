import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, of } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { environment } from '../../environments/environment';
import InsumoViewModel from '../interfaces/InsumoViewModel';
import { InsumoCreateViewModel } from '../interfaces/InsumoCreateViewModel';
import { InsumoDetailViewModel } from '../interfaces/InsumoDetailViewModel';

@Injectable()
export class InsumosService {
  private API_URL = environment.API_URL + 'insumos';

  constructor(private http: HttpClient, private toastr: ToastrService) {}

  get() {
    const url = `${this.API_URL}`;
    return this.http
      .get<InsumoViewModel[]>(url)
      .pipe(map((res: InsumoViewModel[]) => res));
  }

  post(entity: InsumoCreateViewModel) {
    const url = `${this.API_URL}`;
    return this.http.post<any>(url, entity).pipe(
      map((res: any) => {
        this.toastr.success('El insumo se ha guardado correctamente!');

        return res;
      }),
      catchError((e) => {
        this.toastr.error('No se ha podido guardar el insumo');
        return of([]);
      })
    );
  }
  getById(id: number) {
    const url = `${this.API_URL}/${id}`;
    return this.http.get<InsumoDetailViewModel>(url).pipe(
      map((res: InsumoDetailViewModel) => {
        return res;
      })
    );
  }
  put(id: number, entity: InsumoCreateViewModel) {
    const url = `${this.API_URL}/${id}`;
    return this.http.put<InsumoViewModel>(url, entity).pipe(
      map((res: InsumoViewModel) => {
        this.toastr.success('Exito! se han guardado los cambios ');
        return res;
      })
    );
  }
  delete(id: number) {
    const url = `${this.API_URL}/${id}`;
    return this.http.delete<InsumoViewModel>(url).pipe(
      map((res: InsumoViewModel) => {
        this.toastr.success('Exito! se Eliminado el insumo');
        return res;
      })
    );
  }
}
