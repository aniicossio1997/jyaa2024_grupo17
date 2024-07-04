import { Component, HostListener, OnInit } from '@angular/core';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { ITEMS_ROUTERS } from '../../routers/index';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs';
import ConfirmationDialogService from '../ConfirmationDialogService';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrl: './shell.component.scss',
  providers: [ConfirmationService, ConfirmationDialogService],
})
export class ShellComponent implements OnInit {
  isResponsive: boolean = false;
  menuActive!: boolean;
  items: MenuItem[] | undefined;

  home: MenuItem | undefined;

  routesItems = ITEMS_ROUTERS;

  constructor(
    private activatedRoute: ActivatedRoute,
    private confirmationDialogService: ConfirmationDialogService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.menuActive = this.isStatic() && !this.isMobile();
    this.isResponsive = window.innerWidth <= 991;

    this.home = { icon: 'pi pi-home', routerLink: '/' };

    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe((event: any) => {
        const some = this.routesItems.filter(
          (e) =>
            e.routerLink[0] == this.extractBaseRoute(event.urlAfterRedirects)
        );
        if (some[0]) {
          this.items = [{ label: some[0].title }];
        }
      });
  }
  isMobile() {
    return window.innerWidth <= 980;
  }

  isStatic() {
    return true;
  }

  setSidebarVisible() {
    this.isResponsive = !this.isResponsive;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.isResponsive = window.innerWidth <= 991;
  }

  extractBaseRoute(url: string): string {
    // Use split to divide the string and take the first part
    return url.split('/').slice(0, 2).join('/');
  }
}
