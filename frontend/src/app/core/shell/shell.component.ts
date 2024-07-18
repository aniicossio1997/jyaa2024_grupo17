import { Routes, ManagementRoutes } from './../../routers/index';
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
  breadcrumbItems: { label: string; path: string }[] = [];

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
        const some = this.routesItems.filter((e) => {
          this.breadcrumbItems = this.getBreadcrumbItems(
            event.urlAfterRedirects
          );
          return (
            e.routerLink[0] == this.extractBaseRoute(event.urlAfterRedirects)
          );
        });
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
    this.isResponsive = window.innerWidth <= 950;
  }

  extractBaseRoute(url: string): string {
    // Use split to divide the string and take the first part
    return url.split('/').slice(0, 2).join('/');
  }

  getBreadcrumbItems(url: string): { label: string; path: string }[] {
    // Use split to divide the string and take the first part
    const parts = url.split('/');
    const map = {
      [ManagementRoutes.FamiliaProductora]: 'Familias Productoras',
      [ManagementRoutes.Receta]: 'Recetas',
      [ManagementRoutes.MateriaPrima]: 'Materias Primas',
      [ManagementRoutes.Insumo]: 'Insumos',
      [ManagementRoutes.Gestion]: 'Gestión de insumos',
      [ManagementRoutes.Usuario]: 'Usuarios',
      [ManagementRoutes.New]: 'Agregar',
      [ManagementRoutes.Edit]: 'Editar',
      [ManagementRoutes.Detail]: 'Detalle',
      [ManagementRoutes.Elaboracion]: 'Elaboracion',

    };

    const links: { label: string; path: string }[] = [];
    parts.forEach((i) => {
      const label = map[i];
      if (label) {
        let path = i;
        if (links.length > 0) {
          const prevLink = links[links.length - 1];
          path = prevLink.path + '/' + i;
        }
        links.push({ label, path });
      }
      if (links.length > 1) {
        links[links.length - 1].path = '';
      }
    });
    return links;
  }
}
