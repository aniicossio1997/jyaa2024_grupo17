import { Component, OnInit, ViewChild } from '@angular/core';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { ManagementRoutes } from '../../../routers';
import { ActivatedRoute, Router } from '@angular/router';
import { MateriaPrimaDetailViewModel } from '../../../interfaces/MateriaPrimaDetailViewModel';
import { Menu } from 'primeng/menu';
import { Table } from 'primeng/table';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { EstadoIngresoEnums } from '../../../model/EstadoIngresoEnums';
import ConfirmationDialogService from '../../../core/ConfirmationDialogService';
import { IngresoMateriaPrimaShortViewModel } from '../../../interfaces/ingresoMateriaPrimaShortViewModel';
import { IngresoMateriaPrimasService } from '../../../services/ingreso-materia-primas.service';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { IngresoCambiarEstadoComponent } from './ingreso-cambiar-estado/ingreso-cambiar-estado.component';

interface Column {
  field: string;
  header: string;
  sort?:boolean
}

@Component({
  selector: 'app-materia-detail',
  templateUrl: './materia-detail.component.html',
  styleUrl: './materia-detail.component.scss',
  providers:[MateriaPrimaService, ConfirmationService, MessageService,
    IngresoMateriaPrimasService, DialogService
  ]
})
export class MateriaDetailComponent implements OnInit {
  materiaPrimaDetail!:MateriaPrimaDetailViewModel;
  id:number;
  @ViewChild('dt') dt: Table;
  cols!: Column[];
  ref: DynamicDialogRef | undefined;

  itemsMenu: MenuItem[] = [];

  public get RoutestEnum(): typeof ManagementRoutes {
    return ManagementRoutes;
  }

  constructor(private materiaPrimaService: MateriaPrimaService, private activateRouter:ActivatedRoute,
    private router:Router, private confirmationDialogService: ConfirmationDialogService,
    private ingresoMateriaPrimasService:IngresoMateriaPrimasService,
    private dialogService: DialogService
  ){}


  ngOnInit(): void {
    this.getRefresh();
    this.initColumns()

  }

  initColumns(){
    this.cols = [
      { field: 'codigo', header: 'Código', sort:true },
      { field: 'cantidad', header: 'Cantidad',sort:true },
      { field: 'valorCompra', header: 'Valor', sort:true },
      { field: 'familiaProductora', header: 'Familia Productora', sort:true },
      { field: 'fecha', header: 'Fecha de creación', sort:true },
      { field: 'currentState', header: 'Estado', sort:true },


    ];
  }

  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Detalle',
        icon: 'pi pi-eye',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Gestion}/${ManagementRoutes.Detail}/`, item.id]); // Usa item.id para redirigir

        },
      },
      {
        label: 'Cambiar Estado',
        icon: 'pi pi-tags',
        command: () => {
          this.changeState(item)

        },
      },
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Gestion}/${ManagementRoutes.Edit}/`, item.id]); // Usa item.id para redirigir

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
    this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Gestion}/${ManagementRoutes.New}`, this.materiaPrimaDetail.id]); // Usa item.id para redirigir

  }
  back(){
    this.router.navigate([`/${ManagementRoutes.MateriaPrima}`]); // Usa item.id para redirigir

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
  delete(item:IngresoMateriaPrimaShortViewModel) {
    this.confirmationDialogService.confirmDelete(
      `¿Está seguro que desea eliminar el ingreso con codigo ${item.codigo} ?`,
      () => {
        this.ingresoMateriaPrimasService.delete(item.id!).subscribe(() => {
          this.getRefresh();
        });
      }
    );
  }
  getRefresh(){
    this.id = Number(this.activateRouter.snapshot.paramMap.get('id')!);
    this.materiaPrimaService.getById(this.id).subscribe(data=>this.materiaPrimaDetail=data)
  }

  changeState(item:any) {
    const callbackFunction = this.getRefresh.bind(this);
    this.ref = this.dialogService.open(IngresoCambiarEstadoComponent, {
      header: 'Cambiar estado de del ingreso',
      width: '50vw',
      closable:false,
      contentStyle: { overflow: 'visible' },
      data: {
        ingreso:item,
        callback:callbackFunction,
      }
    });

    this.ref.onClose.subscribe((data: any) => {

      // console.log("CLOSE")

    });


  }
}
