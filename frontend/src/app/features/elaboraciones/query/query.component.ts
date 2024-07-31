import { Component, OnInit } from '@angular/core';
import { MenuItem, ConfirmationService, MessageService } from 'primeng/api';
import { Menu } from 'primeng/menu';
import { ManagementRoutes } from '../../../routers';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import ConfirmationDialogService from '../../../core/ConfirmationDialogService';
import RecetaViewModel from '../../../interfaces/RecetaViewModel';
import { ElaboracionService } from '../../../services/elaboracion.service';
import ElaboracionViewModel from '../../../interfaces/ElaboracionViewModel';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { SelectorRecetaComponent } from '../selector-recetas/selector-recetas.component';
import { EstadoElaboracionEnum } from '../../../model/EstadoElaboracionEnum';
import { style } from '@angular/animations';

@Component({
  providers: [
    ElaboracionService,
    ConfirmationService,
    MessageService,
    DialogService,
  ],
  selector: 'elaboraciones-query',
  templateUrl: './query.component.html',
})
export class QueryComponent implements OnInit {
  elaboraciones: ElaboracionViewModel[] = [];
  recetaId: number;
  ref: DynamicDialogRef | undefined;

  loading: boolean = true;

  // Menus
  itemsMenu: MenuItem[] = [];

  constructor(
    private elaboracionService: ElaboracionService,
    private router: Router,
    private toastr: ToastrService,
    private confirmationDialogService: ConfirmationDialogService,
    private activatedRoute: ActivatedRoute,
    private dialogService: DialogService
  ) {}

  ngOnInit(): void {
    this.recetaId = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
    this.fetchAll();
  }

  fetchAll() {
    this.loading = true;
    this.elaboracionService.getAll().subscribe((res) => {
      this.elaboraciones = res;
      this.loading = false;
    });
  }

  public get Routes() {
    return {
      NEW: `/${ManagementRoutes.Elaboracion}/${ManagementRoutes.New}`,
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
            `/${ManagementRoutes.Elaboracion}/${ManagementRoutes.Detail}/`,
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
      '¿Está seguro que desea eliminar la elaboración?',
      () => {
        this.elaboracionService.delete(item.id).subscribe(() => {
          this.toastr.success('Se ha eliminado la elaboracion');
          this.fetchAll();
        });
      }
    );
  }

  openSelectorReceta() {
    this.ref = this.dialogService.open(SelectorRecetaComponent, {
      header: 'Agregar elaboracion',
      width: '50vw',
       breakpoints: {
        '960px': '75vw',
        '640px': '90vw',
      },
      closable: false,
      contentStyle: { overflow: 'visible' },
    });

    this.ref.onClose.subscribe((data: any) => {});
  }

  getEstadoSeverity(estado: string) {
    switch (estado) {
      case EstadoElaboracionEnum.ENTREGADO_COMPLETO:
        return 'success';
      case EstadoElaboracionEnum.ENTREGADO_PARCIAL:
        return 'primary';
      case EstadoElaboracionEnum.EN_DEPOSITO:
        return 'warning';
      case EstadoElaboracionEnum.EN_PROCESO:
        return 'info';
    }
    return '';
  }
}
