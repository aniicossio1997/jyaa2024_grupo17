import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { environment } from '../../environments/environment';
import { EntregaElaboracionViewModel } from '../interfaces/EntregaElaboracionViewModel';

@Injectable()
export class EntregaElaboracionService implements OnDestroy {
  private API_URL = environment.API_URL + 'entregas';

  constructor(private http: HttpClient) {}

  create(req: { cantidad: string, elaboracionId: number, puntoVentaId: number, updateState: boolean, fecha: Date }) {
    return this.http.post<EntregaElaboracionViewModel>(this.API_URL, req);
  }


  ngOnDestroy(): void {}
}
