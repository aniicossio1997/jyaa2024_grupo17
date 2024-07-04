import { Component, OnInit, ViewChild } from '@angular/core';
import { FamiliaProductoraService } from '../familia-productora.service';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { Menu } from 'primeng/menu';
import { Router } from '@angular/router';
import { ManagementRoutes } from '../../../routers/index';
import { FamiliaProductoraViewModel } from '../../../interfaces/FamiliaProductoraViewModel';



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
    this.fetchAll()

  }

  fetchAll(){
    this.familiaProductoraService.get().subscribe(data=>{
      this.familias=data;

    })
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
          this.delete(item);
        },
      },

    ];
  }

  delete(item:FamiliaProductoraViewModel) {

    this.confirmationService.confirm({
      message: '¿Esta seguro de eliminar '+' la familia ' +item.nombre +'?',
      header: 'Confirmar la Eliminación',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon:"none",
      rejectIcon:"none",

      key:"positionDialog",
      acceptButtonStyleClass:"p-button-danger p-button-text ",
      rejectButtonStyleClass:"p-button-secondary p-button-text",
      accept: () => {
          this.familiaProductoraService.delete(item.id!).subscribe(data=>{
            this.fetchAll();
          });
      },
      reject: () => {
        console.log("NO.. ELIMINA")
      }
  });
 }

}
