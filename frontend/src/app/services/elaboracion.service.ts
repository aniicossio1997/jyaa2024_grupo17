import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { map } from 'rxjs';
import RecetaViewModel from '../interfaces/RecetaViewModel';
import { RecetaDetalleViewModel } from '../interfaces/RecetaDetalleViewModel';
import RecetaCreateViewModel from '../interfaces/RecetaCreateViewModel';
import ElaboracionViewModel from '../interfaces/ElaboracionViewModel';
import { ElaboracionCreateViewModel } from '../interfaces/ElaboracionCreateViewModel';
import ElaboracionDetalleViewModel from '../interfaces/ElaboracionDetalleViewModel';

@Injectable()
export class ElaboracionService implements OnDestroy {
  public API_URL = 'http://localhost:8080/SalaDeElaboracion/api/elaboraciones';

  constructor(private http: HttpClient) {}

  getAll(recetaId?:number) {
    return this.http.get<ElaboracionViewModel[]>(this.API_URL + (recetaId ? ("?recetaId=" + recetaId) : ""));
  }

  detail(id: number) {
    return this.http.get<ElaboracionDetalleViewModel>(this.API_URL + '/' + id);
  }

  create(receta: ElaboracionCreateViewModel) {
    return this.http.post<ElaboracionViewModel>(this.API_URL, receta);
  }

  edit(id: number, receta: Partial<RecetaCreateViewModel>) {
    return this.http.put<RecetaDetalleViewModel>(
      this.API_URL + '/' + id,
      receta
    );
  }

  delete(id: number) {
    return this.http
      .delete<void>(this.API_URL + '/' + id)
      .pipe(map((res) => res));
  }

  ngOnDestroy(): void {
  }
}
