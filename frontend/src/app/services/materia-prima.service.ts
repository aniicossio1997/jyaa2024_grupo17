import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable()
export class MateriaPrimaService {
  private API_URL ='http://localhost:8080/SalaDeElaboracion/api' ;


  constructor(private http: HttpClient) { }

  get(){
    const url = `${this.API_URL}/familiaProductoras`;
    return this.http.get<any[]>(url)
      .pipe(
        map((res: any) => res)
        );
  }
}
