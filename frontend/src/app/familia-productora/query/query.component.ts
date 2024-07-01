import { Component, OnInit, ViewChild } from '@angular/core';
import { FamiliaProductoraService } from '../familia-productora.service';
import { ProductService } from '../ProductService';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { Menu } from 'primeng/menu';

interface Product {
  id?: string;
  code?: string;
  name?: string;
  description?: string;
  price?: number;
  quantity?: number;
  inventoryStatus: string;
  category?: string;
  image?: string;
  rating?: number;
}

@Component({
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrl: './query.component.scss',
  providers:[
    FamiliaProductoraService,
    MessageService, ConfirmationService, ProductService
  ]
})
export class QueryComponent  implements OnInit{
  @ViewChild('dt') dt: Table;

  itemsMenu: MenuItem[] = [];

  familias:any[]=[]

  productDialog: boolean = false;


  selectedProducts!: any[] | null;



  constructor(private familiaProductoraService: FamiliaProductoraService,

    private productService: ProductService, private messageService: MessageService,
    private confirmationService: ConfirmationService
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
              this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Products Deleted', life: 3000 });
          }
      });
  }

  editProduct(product: Product) {
      //this.product = { ...product };
      this.productDialog = true;
  }

  deleteProduct(product: Product) {
      this.confirmationService.confirm({
          message: 'Are you sure you want to delete ' + product.name + '?',
          header: 'Confirm',
          icon: 'pi pi-exclamation-triangle',
          accept: () => {
              //this.products = this.products.filter((val) => val.id !== product.id);
              //this.product = null!;
              this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Deleted', life: 3000 });
          }
      });
  }

  hideDialog() {
      this.productDialog = false;
      //this.submitted = false;
  }

  saveProduct() {

  }


  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Ver detalle',
        icon: 'pi pi-eye',
        command: () => {

        },
        visible: true,
        // visible: item.canViewDetail
      },
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          // Add your code here
        },
      },
      {
        label: 'Eliminar',
        icon: 'pi pi-file',
        command: () => {

        },
      },

    ];
  }
}
