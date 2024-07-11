import { ThemeService } from './../../services/theme.service';
import { CommonModule } from '@angular/common';
import {
  CUSTOM_ELEMENTS_SCHEMA,
  Component,
  Input,
  OnDestroy,
  OnInit,
  ViewChild,
} from '@angular/core';
import { Router } from '@angular/router';
import { AvatarModule } from 'primeng/avatar';
import { ButtonModule } from 'primeng/button';
import { ButtonGroupModule } from 'primeng/buttongroup';
import { DragDropModule } from 'primeng/dragdrop';
import { InputTextModule } from 'primeng/inputtext';
import { MenuModule } from 'primeng/menu';
import { MenubarModule } from 'primeng/menubar';
import { Sidebar, SidebarModule } from 'primeng/sidebar';
import { StyleClassModule } from 'primeng/styleclass';
import { ItemMenuComponent } from '../item-menu/item-menu.component';
import { IRouteModel, ITEMS_ROUTERS } from '../../routers';
import { Subscription } from 'rxjs';

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
    ItemMenuComponent,
  ],

  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss',
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class SidebarComponent implements OnInit, OnDestroy{
  @Input() isResponsive!: boolean;
  @ViewChild('sidebarRef') sidebarRef!: Sidebar;
  subs=new Subscription();
  sidebarVisible: boolean = false;
  event:any
  itemsRoutes: IRouteModel[] = ITEMS_ROUTERS;

  constructor(private router: Router, private themeService: ThemeService) {

  }
  ngOnDestroy(): void {
    this.subs?.unsubscribe()
  }

  closeCallback(e: any): void {
    this.event=e;
    this.sidebarRef.close(this.event);
  }

  toggleTheme(){
    this.themeService.toggleTheme();
  }

  get themeIcon(): string {
    return this.themeService.theme === 'light' ? 'pi pi-sun' : 'pi pi-moon'; // Emoji for illustration; replace with icon classes if needed
  }


  ngOnInit(): void {
    this.router.events.subscribe((val) =>
    {
      if(this.event){
        this.closeCallback(this.event);
      }
    }
    );
  }
}
