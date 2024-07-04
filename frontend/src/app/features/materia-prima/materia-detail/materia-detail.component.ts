import { Component, OnInit, ViewChild } from '@angular/core';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { ManagementRoutes } from '../../../routers';
import { ActivatedRoute, Router } from '@angular/router';
import { MateriaPrimaDetailViewModel } from '../../../interfaces/MateriaPrimaDetailViewModel';
import { Menu } from 'primeng/menu';
import { Table } from 'primeng/table';
import { MenuItem } from 'primeng/api';
import { EstadoIngresoEnums } from '../../../model/EstadoIngresoEnums';

interface Column {
  field: string;
  header: string;
  sort?:boolean
}

@Component({
  selector: 'app-materia-detail',
  templateUrl: './materia-detail.component.html',
  styleUrl: './materia-detail.component.scss',
  providers:[MateriaPrimaService]
})
export class MateriaDetailComponent implements OnInit {
  materiaPrimaDetail!:MateriaPrimaDetailViewModel;
  id:number;
  @ViewChild('dt') dt: Table;
  cols!: Column[];

  itemsMenu: MenuItem[] = [];

  public get RoutestEnum(): typeof ManagementRoutes {
    return ManagementRoutes;
  }

  constructor(private materiaPrimaService: MateriaPrimaService, private activateRouter:ActivatedRoute,
    private router:Router
  ){

  }
  ngOnInit(): void {
    this.id = Number(this.activateRouter.snapshot.paramMap.get('id')!);
    this.materiaPrimaService.getById(this.id).subscribe(data=>this.materiaPrimaDetail=data)
    this.initColumns()

  }

  initColumns(){
    this.cols = [
      { field: 'fecha', header: 'Fecha', sort:true },
      { field: 'cantidad', header: 'Cantidad',sort:true },
      { field: 'valorCompra', header: 'Valor de compra', sort:true },
      { field: 'familiaProductora', header: 'familia Productora', sort:true },
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
          //this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Detail}/`, item.id]); // Usa item.id para redirigir

        },
      },
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          //this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Edit}/`, item.id]); // Usa item.id para redirigir

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
  toAddIngreso(){
    this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.AddIngresos}/`, this.materiaPrimaDetail.id]); // Usa item.id para redirigir

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

}
