import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { environment } from '../../environments/environment';
import { EstadoViewModel } from '../interfaces/EstadoViewModel';

@Injectable()
export class EstadoElaboracionService implements OnDestroy {
  private API_URL = environment.API_URL + 'estadoelaboracion';

  constructor(private http: HttpClient) {}

  create(req: { estado: string, elaboracionId: number, fecha: number }) {
    return this.http.post<EstadoViewModel>(this.API_URL, req);
  }


  ngOnDestroy(): void {}
}
