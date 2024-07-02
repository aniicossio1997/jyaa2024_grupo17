import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { map } from 'rxjs';
import { UsuarioViewModel } from '../interfaces/UsuarioViewModel';

@Injectable()
export class UsuariosService implements OnDestroy {
  public API_URL = 'http://localhost:8080/SalaDeElaboracion/api/usuarios';

  constructor(private http: HttpClient) {}

  get() {
    return this.http
      .get<UsuarioViewModel[]>(this.API_URL)
      .pipe(map((res: UsuarioViewModel[]) => res));
  }

  create(usuario: Omit<UsuarioViewModel, 'id'>) {
    return this.http
      .post<UsuarioViewModel>(this.API_URL, usuario)
      .pipe(map((res: UsuarioViewModel) => res));
  }

  ngOnDestroy(): void {
    console.log('DESTROY');
  }
}
