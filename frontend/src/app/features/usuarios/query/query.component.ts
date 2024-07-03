import { Component, OnInit, ViewChild } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { NameableViewModel } from '../../../interfaces/NameableViewModel';
import { MenuItem, ConfirmationService, MessageService } from 'primeng/api';
import { Menu } from 'primeng/menu';
import { ManagementRoutes } from '../../../routers';
import { Router } from '@angular/router';
import { UsuarioViewModel } from '../../../interfaces/UsuarioViewModel';
import { ToastrService } from 'ngx-toastr';

@Component({
  providers: [UsuariosService, ConfirmationService, MessageService],
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrl: './query.component.scss',
})
export class QueryComponent implements OnInit {
  usuarios: NameableViewModel[] = [];
  loading: boolean = true;

  // Menus
  itemsMenu: MenuItem[] = [];

  constructor(
    private usuariosService: UsuariosService,
    private router: Router,
    private confirmationService: ConfirmationService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.fetchUsers();
  }

  fetchUsers() {
    this.loading = true;
    this.usuariosService.get().subscribe((res) => {
      this.usuarios = res;
      this.loading = false;
    });
  }

  public get Routes() {
    return {
      NEW: `/${ManagementRoutes.Usuario}/${ManagementRoutes.New}`,
    };
  }

  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          this.router.navigate([
            `/${ManagementRoutes.Usuario}/${ManagementRoutes.Edit}/`,
            item.id,
          ]);
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

  delete(item: UsuarioViewModel) {
    this.confirmationService.confirm({
      message: '¿Está seguro que desea eliminar el usuario?',
      header: 'Confirmar la Eliminación',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon: 'none',
      rejectIcon: 'none',
      key: 'positionDialog',
      acceptButtonStyleClass: 'p-button-danger p-button-text ',
      rejectButtonStyleClass: 'p-button-secondary p-button-text',
      accept: () => {
        this.usuariosService.delete(item.id).subscribe(() => {
          this.toastr.success('Se ha eliminado el usuario');
          this.fetchUsers();
        });
      },
      reject: () => {},
    });
  }
}
