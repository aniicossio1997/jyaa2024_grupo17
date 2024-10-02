import { Component, OnInit, ViewChild } from '@angular/core';
import { ManagementRoutes } from '../../../routers';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { Router } from '@angular/router';
import { Table } from 'primeng/table';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { Menu } from 'primeng/menu';
import ConfirmationDialogService from '../../../core/ConfirmationDialogService';
import { MateriaPrimaViewModel } from '../../../interfaces/MateriaPrimaViewModel';

interface Column {
  field: string;
  header: string;
}

@Component({
  selector: 'app-materia-query',
  templateUrl: './materia-query.component.html',
  styleUrl: './materia-query.component.scss',
  providers:[MateriaPrimaService,  ConfirmationService, MessageService]
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
    private router:Router, private confirmationDialogService: ConfirmationDialogService
  ){

  }
  ngOnInit(): void {
    this.initColumns()
    this.getAll()
  }

  initColumns(){
    this.cols = [
      { field: 'nombre', header: 'Nombre' },
      { field: 'unidadMedida', header: 'Unidad de medida' },
      { field: 'totalCantidadDisponible', header: 'Total cantidad disponible' },
      
    ];
  }

  generateMenu(item: MateriaPrimaViewModel, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Gestionar ingresos',
        icon: 'pi pi-arrow-right-arrow-left ',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Gestion}/`, item.id]); // Usa item.id para redirigir

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
          this.delete(item)
        },
      },

    ];
  }

  delete(item:MateriaPrimaViewModel) {
    this.confirmationDialogService.confirmDelete(
      `¿Está seguro que desea eliminar la materia prima ${item.nombre.toLocaleUpperCase()} ?`,
      () => {
        this.materiaPrimaService.delete(item.id!).subscribe(() => {
          this.getAll();
        });
      }
    );
  }
  getAll(){
    this.materiaPrimaService.get().subscribe(data=> this.materias=data)
  }
}
