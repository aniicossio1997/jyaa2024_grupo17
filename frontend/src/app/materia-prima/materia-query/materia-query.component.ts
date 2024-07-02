import { Component, OnInit, ViewChild } from '@angular/core';
import { ManagementRoutes } from '../../routers';
import { MateriaPrimaService } from '../../services/materia-prima.service';
import { Router } from '@angular/router';
import { Table } from 'primeng/table';
import { MenuItem } from 'primeng/api';

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
  }

  initColumns(){
    /*
    id": 1,
    "nombre": "Tomate",
    "unidadMedida": "KG",
    "totalCantidadDisponible": 20,
    "totalValorCompra": 25000

    */

    this.cols = [
      { field: 'nombre', header: 'Nombre' },
      { field: 'unidadMedida', header: 'Unidad de medida' },
      { field: 'totalCantidadDisponible', header: 'Total cantidad disponible' },
      { field: 'totalValorCompra', header: 'Total valor de compra' }
    ];
  }

}
