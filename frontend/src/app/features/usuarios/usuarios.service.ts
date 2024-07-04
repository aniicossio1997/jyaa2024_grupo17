import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { map } from 'rxjs';
import { UsuarioViewModel } from '../../interfaces/UsuarioViewModel';
import { environment } from '../../../environments/environment';

@Injectable()
export class UsuariosService implements OnDestroy {
  public API_URL = environment.API_URL + 'usuarios';

  constructor(private http: HttpClient) {}

  get() {
    return this.http
      .get<UsuarioViewModel[]>(this.API_URL)
      .pipe(map((res: UsuarioViewModel[]) => res));
  }

  detail(id: number) {
    return this.http
      .get<UsuarioViewModel>(this.API_URL + '/' + id)
      .pipe(map((res: UsuarioViewModel) => res));
  }

  create(usuario: Omit<UsuarioViewModel, 'id'>) {
    return this.http
      .post<UsuarioViewModel>(this.API_URL, usuario)
      .pipe(map((res: UsuarioViewModel) => res));
  }

  edit(id: number, usuario: Partial<UsuarioViewModel>) {
    return this.http
      .put<UsuarioViewModel>(this.API_URL + '/' + id, usuario)
      .pipe(map((res: UsuarioViewModel) => res));
  }

  delete(id: number) {
    return this.http.delete<void>(this.API_URL + '/' + id).pipe(map((res) => res));
  }

  ngOnDestroy(): void {
    console.log('DESTROY');
  }
}
