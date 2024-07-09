import { Component, ViewChild } from '@angular/core';
import { EstadoIngresoEnums } from '../../../model/EstadoIngresoEnums';
import { ManagementRoutes } from '../../../routers';
import InsumoViewModel from '../../../interfaces/InsumoViewModel';
import { Table } from 'primeng/table';
import { IColumn } from '../../../model/IColumn';
import { MenuItem } from 'primeng/api';
import { InsumosService } from '../../../services/insumo.service';
import { ActivatedRoute, Router } from '@angular/router';
import ConfirmationDialogService from '../../../core/ConfirmationDialogService';
import { Menu } from 'primeng/menu';
import { InsumoDetailViewModel } from '../../../interfaces/InsumoDetailViewModel';
import { IngresoInsumoService } from '../../../services/ingreso-insumo.service';
import { IngresoInsumoViewModel } from '../../../interfaces/IngresoInsumoViewModel';

@Component({
  selector: 'app-insumo-detail',
  templateUrl: './insumo-detail.component.html',
  styleUrl: './insumo-detail.component.scss',
  providers:[InsumosService, IngresoInsumoService]
})
export class InsumoDetailComponent {

  insumo!:InsumoDetailViewModel;
  id:number;
  @ViewChild('dt') dt: Table;
  cols!: IColumn[];

  itemsMenu: MenuItem[] = [];

  public get RoutestEnum(): typeof ManagementRoutes {
    return ManagementRoutes;
  }

  constructor(private insumosService: InsumosService, private activateRouter:ActivatedRoute,
    private router:Router, private confirmationDialogService: ConfirmationDialogService,
    private ingresoInsumoService: IngresoInsumoService
  ){}


  ngOnInit(): void {
    this.getRefresh();
    this.initColumns()

  }

  initColumns(){
    this.cols = [
      { field: 'codigo', header: 'Codigo', sort:true },
      { field: 'cantidad', header: 'Cantidad',sort:true },
      { field: 'valorCompra', header: 'Valor', sort:true },
      { field: 'fecha', header: 'Fecha de creacion', sort:true },
      { field: 'descripcion', header: 'Descripcion', sort:true },

    ];
  }

  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.Insumo}/${ManagementRoutes.Gestion}/${ManagementRoutes.Edit}/`, item.id]); // Usa item.id para redirigir

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
  toAddIngreso(){
    this.router.navigate([`/${ManagementRoutes.Insumo}/${ManagementRoutes.Gestion}/${ManagementRoutes.New}/`,
       this.insumo.id]); // Usa item.id para redirigir

  }
  back(){
    this.router.navigate([`/${ManagementRoutes.Insumo}`]); // Usa item.id para redirigir

  }
  getSeverity(estado:EstadoIngresoEnums) {
    switch (estado) {
        case EstadoIngresoEnums.CAMARA_FRIO:
            return 'primary';
        case EstadoIngresoEnums.ESTANTE:
            return 'warning';
        case EstadoIngresoEnums.FREEZER:
            return 'info';
    }
  }
  delete(item:IngresoInsumoViewModel) {
    this.confirmationDialogService.confirmDelete(
      `¿Está seguro que desea eliminar el ingreso con codigo ${item.codigo} ?`,
      () => {
        this.ingresoInsumoService.delete(item.id!).subscribe(() => {
          this.getRefresh();
        });
      }
    );
  }
  getRefresh(){
    this.id = Number(this.activateRouter.snapshot.paramMap.get('id')!);
    this.insumosService.getById(this.id).subscribe(data=>this.insumo=data)
  }
}
