import { Component, OnInit, ViewChild } from '@angular/core';
import { ManagementRoutes } from '../../../routers';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { Router } from '@angular/router';
import { Table } from 'primeng/table';
import { MenuItem } from 'primeng/api';
import { Menu } from 'primeng/menu';

interface Column {
  field: string;
  header: string;
}

@Component({
  selector: 'app-materia-query',
  templateUrl: './materia-query.component.html',
  styleUrl: './materia-query.component.scss',
  providers:[MateriaPrimaService]
})
export class MateriaQueryComponent implements OnInit {

  @ViewChild('dt') dt: Table;
  cols!: Column[];

  itemsMenu: MenuItem[] = [];

  materias:any[]=[]
  public get RoutestEnum(): typeof ManagementRoutes {
    return ManagementRoutes;
  }


  constructor(private materiaPrimaService: MateriaPrimaService,
    private router:Router
  ){

  }
  ngOnInit(): void {
    this.initColumns()
    this.materiaPrimaService.get().subscribe(data=> this.materias=data)
  }

  initColumns(){
    this.cols = [
      { field: 'nombre', header: 'Nombre' },
      { field: 'unidadMedida', header: 'Unidad de medida' },
      { field: 'totalCantidadDisponible', header: 'Total cantidad disponible' },
      { field: 'totalValorCompra', header: 'Total valor de compra' }
    ];
  }

  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Detalle',
        icon: 'pi pi-eye',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Detail}/`, item.id]); // Usa item.id para redirigir

        },
      },
      {
        label: 'Gestionar ingresos',
        icon: 'pi pi-arrow-right',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.AddIngresos}/`, item.id]); // Usa item.id para redirigir

        },
      },
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Edit}/`, item.id]); // Usa item.id para redirigir

        },
      },
      {
        label: 'Eliminar',
        icon: 'pi pi-trash',
        command: () => {
          //this.delete(item);
        },
      },

    ];
  }

}
