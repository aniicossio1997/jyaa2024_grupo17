import { Component, OnInit, ViewChild } from '@angular/core';
import { FamiliaProductoraService } from '../familia-productora.service';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { Menu } from 'primeng/menu';
import { ManagementRoutes } from '../../routers';
import { Router } from '@angular/router';



@Component({
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrl: './query.component.scss',
  providers:[
    FamiliaProductoraService,
    MessageService, ConfirmationService,
  ]
})
export class QueryComponent  implements OnInit{
  @ViewChild('dt') dt: Table;

  itemsMenu: MenuItem[] = [];

  familias:any[]=[]

  productDialog: boolean = false;


  selectedProducts!: any[] | null;
  public get RoutestEnum(): typeof ManagementRoutes {
    return ManagementRoutes;
  }


  constructor(private familiaProductoraService: FamiliaProductoraService,

    private confirmationService: ConfirmationService,
    private router:Router
  ){

  }

  ngOnInit(): void {
    this.familiaProductoraService.get().subscribe(data=>{
      this.familias=data;

    })

  }



  openNew() {

      //this.submitted = false;
      this.productDialog = true;
  }

  deleteSelectedProducts() {
      this.confirmationService.confirm({
          message: 'Are you sure you want to delete the selected products?',
          header: 'Confirm',
          icon: 'pi pi-exclamation-triangle',
          accept: () => {
              this.selectedProducts = null;
          }
      });
  }





  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          this.router.navigate([`/${ManagementRoutes.FamiliaProductora}/${ManagementRoutes.Edit}/`, item.id]); // Usa item.id para redirigir

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
