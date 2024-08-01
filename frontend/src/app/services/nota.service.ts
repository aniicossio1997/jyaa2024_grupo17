import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { map } from 'rxjs';
import RecetaViewModel from '../interfaces/RecetaViewModel';
import { RecetaDetalleViewModel } from '../interfaces/RecetaDetalleViewModel';
import RecetaCreateViewModel from '../interfaces/RecetaCreateViewModel';
import { environment } from '../../environments/environment';
import NotaViewModel from '../interfaces/NotaViewModel';

@Injectable()
export class NotaService implements OnDestroy {
  private API_URL = environment.API_URL + 'notas';

  constructor(private http: HttpClient) {}

  create(nota: { descripcion: string; elaboracionId: number }) {
    return this.http.post<NotaViewModel>(this.API_URL, nota);
  }

  delete(id: number) {
    return this.http
      .delete<void>(this.API_URL + '/' + id)
      .pipe(map((res) => res));
  }

  ngOnDestroy(): void {}
}
