import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import ConfirmationDialogService from '../../../../core/ConfirmationDialogService';
import { ManagementRoutes } from '../../../../routers';
import { IngresoMateriaPrimasService } from '../../../../services/ingreso-materia-primas.service';
import { IngresoMateriaPrimaDetailViewModel } from '../../../../interfaces/IngresoMateriaPrimaDetailViewModel';
import { Table } from 'primeng/table';
import { EstadoIngresoEnums } from '../../../../model/EstadoIngresoEnums';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { IngresoCambiarEstadoComponent } from '../ingreso-cambiar-estado/ingreso-cambiar-estado.component';
interface Column {
  field: string;
  header: string;
  sort?:boolean
}


@Component({
  selector: 'app-ingreso-detail',
  templateUrl: './ingreso-detail.component.html',
  styleUrl: './ingreso-detail.component.scss',
  providers:[IngresoMateriaPrimasService,DialogService]
})


export class IngresoDetailComponent implements OnInit {
  id:number
  ingreso!: IngresoMateriaPrimaDetailViewModel;
  @ViewChild('dt') dt: Table;
  cols!: Column[];


  constructor(private activatedRoute:ActivatedRoute,
    private router:Router, private confirmationDialogService: ConfirmationDialogService,
    private ingresoMateriaPrimasService: IngresoMateriaPrimasService,

  ){}


  ngOnInit(): void {
    this.initColumns()
    this.getRefresh()
  }


  back(){
    this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Gestion}/`, this.ingreso.materiaPrima.id!]); // Usa item.id para redirigir

  }

  getRefresh(){
    this.id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
    this.ingresoMateriaPrimasService.getById(this.id).subscribe(data=>this.ingreso=data!)
  }

  initColumns(){
    this.cols = [

      { field: 'autor', header: 'Autor', sort:true },
      { field: 'fecha', header: 'Fecha de creacion', sort:true },
      { field: 'estado', header: 'Estado', sort:true },


    ];
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
