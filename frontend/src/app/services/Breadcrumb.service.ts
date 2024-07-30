import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

export interface Breadcrumb {
  label: string;
  url: string;
}

@Injectable({
  providedIn: 'root'
})
export class BreadcrumbService {
  private breadcrumbsSubject = new BehaviorSubject<Breadcrumb[]>([]);
  breadcrumbs$: Observable<Breadcrumb[]> = this.breadcrumbsSubject.asObservable();

  setBreadcrumbs(breadcrumbs: Breadcrumb[]) {
    this.breadcrumbsSubject.next(breadcrumbs);
  }

  init(){

  }
}
