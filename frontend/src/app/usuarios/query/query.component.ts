import { Component, OnInit, ViewChild } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { NameableViewModel } from '../../interfaces/NameableViewModel';
import { MenuItem } from 'primeng/api';
import { Table } from 'primeng/table';
import { Menu } from 'primeng/menu';
import { ManagementRoutes } from '../../routers';

@Component({
  providers: [UsuariosService],
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrl: './query.component.scss',
})
export class QueryComponent implements OnInit {
  usuarios: NameableViewModel[] = [];

  // Menus
  itemsMenu: MenuItem[] = [];
  
  constructor(private usuariosService: UsuariosService) {}
  ngOnInit(): void {
    this.usuariosService.get().subscribe((res) => (this.usuarios = res));
  }

  public get Routes(){
    return ({
      NEW: `/${ManagementRoutes.Usuario}/${ManagementRoutes.New}`
    });
  }

  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
        },
      },
      {
        label: 'Eliminar',
        icon: 'pi pi-trash',
        command: () => {

        },
      },

    ];
  }
}
