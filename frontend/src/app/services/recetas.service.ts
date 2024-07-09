import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { map } from 'rxjs';
import RecetaViewModel from '../interfaces/RecetaViewModel';
import { RecetaDetalleViewModel } from '../interfaces/RecetaDetalleViewModel';
import RecetaCreateViewModel from '../interfaces/RecetaCreateViewModel';

@Injectable()
export class RecetasService implements OnDestroy {
  public API_URL = 'http://localhost:8080/SalaDeElaboracion/api/recetas';

  constructor(private http: HttpClient) {}

  get() {
    return this.http.get<RecetaViewModel[]>(this.API_URL);
  }

  detail(id: number) {
    return this.http.get<RecetaDetalleViewModel>(this.API_URL + '/' + id);
  }

  create(receta: RecetaCreateViewModel) {
    return this.http.post<RecetaDetalleViewModel>(this.API_URL, receta);
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
    console.log('DESTROY');
  }
}
