import { Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { Menu } from 'primeng/menu';
import { Router } from '@angular/router';
import { ManagementRoutes } from '../../../routers/index';
import { PuntoVentaService } from '../punto-venta.service';
import { PuntoVentaViewModel } from '../../../interfaces/PuntoVentaViewModel';

@Component({
  selector: 'app-query',
  templateUrl: './query.component.html',
  providers: [PuntoVentaService, MessageService, ConfirmationService],
})
export class QueryComponent implements OnInit {
  @ViewChild('dt') dt: Table;

  itemsMenu: MenuItem[] = [];

  puntosVenta: PuntoVentaViewModel[] = [];

  productDialog: boolean = false;

  selectedProducts!: any[] | null;
  public get RoutestEnum(): typeof ManagementRoutes {
    return ManagementRoutes;
  }

  constructor(
    private puntoVentaService: PuntoVentaService,
    private confirmationService: ConfirmationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchAll();
  }

  fetchAll() {
    this.puntoVentaService.get().subscribe((data) => {
      this.puntosVenta = data;
    });
  }

  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          this.router.navigate([
            `/${ManagementRoutes.PuntoVenta}/${ManagementRoutes.Edit}/`,
            item.id,
          ]); // Usa item.id para redirigir
        },
      },
      {
        label: 'Eliminar',
        icon: 'pi pi-trash',
        command: () => {
          this.delete(item);
        },
      },
    ];
  }

  delete(item: PuntoVentaViewModel) {
    this.confirmationService.confirm({
      message:
        '¿Esta seguro de eliminar ' + ' el punto de venta ' + item.nombre + '?',
      header: 'Confirmar la Eliminación',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon: 'none',
      rejectIcon: 'none',

      key: 'positionDialog',
      acceptButtonStyleClass: 'p-button-danger p-button-text ',
      rejectButtonStyleClass: 'p-button-secondary p-button-text',
      accept: () => {
        this.puntoVentaService.delete(item.id!).subscribe((data) => {
          this.fetchAll();
        });
      },
      reject: () => {},
    });
  }
}
