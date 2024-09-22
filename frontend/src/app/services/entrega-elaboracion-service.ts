import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { environment } from '../../environments/environment';
import { EntregaElaboracionViewModel } from '../interfaces/EntregaElaboracionViewModel';

@Injectable()
export class EntregaElaboracionService implements OnDestroy {
  private API_URL = environment.API_URL + 'entregas';

  constructor(private http: HttpClient) {}

  create(req: {
    cantidad: string;
    elaboracionId: number;
    puntoVentaId: number;
    updateState: boolean;
    fecha: Date;
  }) {
    return this.http.post<EntregaElaboracionViewModel>(this.API_URL, req);
  }

  getAll(req: { elaboracionId?: number; puntoVentaId?: number }) {
    const params = new URLSearchParams();

    if (req.elaboracionId) {
      params.append('elaboracionId', req.elaboracionId.toString());
    } else if (req.puntoVentaId) {
      params.append('puntoVentaId', req.puntoVentaId.toString());
    }

    const queryString = params.toString() ? `?${params.toString()}` : '';
    return this.http.get<EntregaElaboracionViewModel[]>(
      `${this.API_URL}${queryString}`
    );
  }

  ngOnDestroy(): void {}
}
