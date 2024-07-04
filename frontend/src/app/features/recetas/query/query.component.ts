import { Component, OnInit } from '@angular/core';
import { MenuItem, ConfirmationService, MessageService } from 'primeng/api';
import { Menu } from 'primeng/menu';
import { ManagementRoutes } from '../../../routers';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import ConfirmationDialogService from '../../../core/ConfirmationDialogService';
import { RecetasService } from '../recetas.service';
import RecetaViewModel from '../../../interfaces/RecetaViewModel';

@Component({
  providers: [RecetasService, ConfirmationService, MessageService],
  selector: 'app-query',
  templateUrl: './query.component.html',
})
export class QueryComponent implements OnInit {
  recetas: RecetaViewModel[] = [];
  loading: boolean = true;

  // Menus
  itemsMenu: MenuItem[] = [];

  constructor(
    private recetasService: RecetasService,
    private router: Router,
    private toastr: ToastrService,
    private confirmationDialogService: ConfirmationDialogService
  ) {}

  ngOnInit(): void {
    this.fetchAll();
  }

  fetchAll() {
    this.loading = true;
    this.recetasService.get().subscribe((res) => {
      this.recetas = res;
      this.loading = false;
    });
  }

  public get Routes() {
    return {
      NEW: `/${ManagementRoutes.Receta}/${ManagementRoutes.New}`,
    };
  }

  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Detalle',
        icon: 'pi pi-eye',
        command: () => {
          this.router.navigate([
            `/${ManagementRoutes.Receta}/${ManagementRoutes.Detail}/`,
            item.id,
          ]);
        },
      },
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          this.router.navigate([
            `/${ManagementRoutes.Receta}/${ManagementRoutes.Edit}/`,
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

  delete(item: RecetaViewModel) {
    this.confirmationDialogService.confirmDelete(
      '¿Está seguro que desea eliminar la receta?',
      () => {
        this.recetasService.delete(item.id).subscribe(() => {
          this.toastr.success('Se ha eliminado la receta');
          this.fetchAll();
        });
      }
    );
  }
}
