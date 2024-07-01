import { CommonModule } from '@angular/common';
import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';


import { AvatarModule } from 'primeng/avatar';
import { ButtonModule } from 'primeng/button';
import { ButtonGroupModule } from 'primeng/buttongroup';
import { MenuModule } from 'primeng/menu';
import { MenubarModule } from 'primeng/menubar';
import { StyleClassModule } from 'primeng/styleclass';
import { Subscription, filter } from 'rxjs';
import { IRouteModel } from '../../routers';

@Component({
  selector: 'app-item-menu',
  templateUrl: './item-menu.component.html',
  styleUrl: './item-menu.component.scss',
  standalone: true,
  imports: [
    ButtonGroupModule,
    ButtonModule,
    MenuModule,
    MenubarModule,
    AvatarModule,
    StyleClassModule,
    CommonModule
  ],
})
export class ItemMenuComponent  implements OnInit,OnDestroy{
  active=false;
  currentRoute: string='';
  subs=new Subscription();
  @Input() item!:IRouteModel;
  constructor(public router: Router, private activatedRoute: ActivatedRoute){

  }
  ngOnDestroy(): void {
    this.subs?.unsubscribe();
  }
  ngOnInit(): void {

    this.currentRoute = this.extractBaseRoute(this.router.url);

    this.subs.add(
      this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: any) => {
        this.currentRoute = this.extractBaseRoute(event.urlAfterRedirects);
      })
    )


  }

  updateActiveStateFromRoute() {
    let activeRoute = this.router.isActive(this.item.routerLink[0], { paths: 'exact', queryParams: 'ignored', matrixParams: 'ignored', fragment: 'ignored' });
  }
  extractBaseRoute(url: string): string {
    // Use split to divide the string and take the first part
    return url.split('/').slice(0, 2).join('/');
  }
}
