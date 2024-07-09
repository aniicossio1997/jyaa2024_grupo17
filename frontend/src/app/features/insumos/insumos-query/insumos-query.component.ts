import { Component, OnInit } from '@angular/core';
import { InsumosService } from '../../../services/insumo.service';
import InsumoViewModel from '../../../interfaces/InsumoViewModel';
import { IColumn } from '../../../model/IColumn';
import { ManagementRoutes } from '../../../routers';
import ConfirmationDialogService from '../../../core/ConfirmationDialogService';
import { Router } from '@angular/router';
import { Menu } from 'primeng/menu';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-insumos-query',
  templateUrl: './insumos-query.component.html',
  styleUrl: './insumos-query.component.scss',
  providers:[InsumosService]
})
export class InsumosQueryComponent implements OnInit {

  cols:IColumn[]=[];
  insumos:InsumoViewModel[]=[]
  itemsMenu: MenuItem[] = [];



  public get RoutestEnum(): typeof ManagementRoutes {
    return ManagementRoutes;
  }

  constructor(private insumosService:InsumosService, private confirmationDialogService: ConfirmationDialogService,
    private router:Router
  ){}
  ngOnInit(): void {
    this.initColumns()
    this.getAll();
  }

  initColumns(){
    this.cols = [
      { field: 'nombre', header: 'Nombre' },
      { field: 'unidadMedida', header: 'Unidad de medida' },
      { field: 'totalCantidadDisponible', header: 'Total cantidad disponible' },
      { field: 'totalValorCompra', header: 'Total valor de compra' }
    ];
  }

  getAll(){
    this.insumosService.get().subscribe(data=> this.insumos=data)
  }
  generateMenu(item: InsumoViewModel, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Gestionar ingresos',
        icon: 'pi pi-arrow-right-arrow-left ',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.Insumo}/${ManagementRoutes.Gestion}/`, item.id]); // Usa item.id para redirigir

        },
      },
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.Insumo}/${ManagementRoutes.Edit}/`, item.id]); // Usa item.id para redirigir

        },
      },
      {
        label: 'Eliminar',
        icon: 'pi pi-trash',
        command: () => {
          this.delete(item)
        },
      },

    ];
  }

  delete(item:InsumoViewModel) {
    this.confirmationDialogService.confirmDelete(
      `¿Está seguro que desea eliminar la materia prima ${item.nombre.toLocaleUpperCase()} ?`,
      () => {
        this.insumosService.delete(item.id!).subscribe(() => {
          this.getAll();
        });
      }
    );
  }
}
