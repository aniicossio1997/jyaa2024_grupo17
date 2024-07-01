import { CommonModule } from "@angular/common";
import { CUSTOM_ELEMENTS_SCHEMA, Component, Input, OnInit, ViewChild } from "@angular/core";
import { Router } from "@angular/router";
import { AvatarModule } from "primeng/avatar";
import { ButtonModule } from "primeng/button";
import { ButtonGroupModule } from "primeng/buttongroup";
import { DragDropModule } from "primeng/dragdrop";
import { InputTextModule } from "primeng/inputtext";
import { MenuModule } from "primeng/menu";
import { MenubarModule } from "primeng/menubar";
import { Sidebar, SidebarModule } from "primeng/sidebar";
import { StyleClassModule } from "primeng/styleclass";
import { ItemMenuComponent } from "../item-menu/item-menu.component";
import { IRouteModel, ITEMS_ROUTERS } from "../../routers";


@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [
    DragDropModule,
    SidebarModule,
    ButtonGroupModule,
    ButtonModule,
    MenuModule,
    MenubarModule,
    AvatarModule,
    StyleClassModule,
    CommonModule,
    ItemMenuComponent
  ],


  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss',
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class SidebarComponent  implements OnInit{
  @Input() isResponsive!:boolean;
  @ViewChild('sidebarRef') sidebarRef!: Sidebar;

  itemsRoutes:IRouteModel[]=ITEMS_ROUTERS;


  closeCallback(e:any): void {
      this.sidebarRef.close(e);
  }

  sidebarVisible: boolean = false;
  ngOnInit(): void {
  }


}
