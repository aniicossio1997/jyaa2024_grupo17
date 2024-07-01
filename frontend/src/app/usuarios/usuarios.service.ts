import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { map } from 'rxjs';
import { NameableViewModel } from '../interfaces/NameableViewModel';

@Injectable()
export class UsuariosService implements OnDestroy {
  public API_URL = 'http://localhost:8080/SalaDeElaboracion/api/usuarios';

  constructor(private http: HttpClient) {}

  get() {
    const url = `${this.API_URL}`;
    return this.http.get<NameableViewModel[]>(url).pipe(map((res: any) => res));
  }

  ngOnDestroy(): void {
    console.log('DESTROY');
  }
}
