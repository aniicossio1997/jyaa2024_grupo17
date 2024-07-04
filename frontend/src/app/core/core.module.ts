import { ConfirmationService } from 'primeng/api';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShellComponent } from './shell/shell.component';
import { CoreRoutingModule } from './core-routing.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { BreadcrumbModule } from 'primeng/breadcrumb';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import ConfirmationDialogService from './ConfirmationDialogService';

@NgModule({
  declarations: [
    ShellComponent,

  ],
  imports: [
    CommonModule,
    CoreRoutingModule,
    SidebarComponent,
    BreadcrumbModule,
    ConfirmDialogModule,
  ],
  exports:[ShellComponent],
  schemas:[CUSTOM_ELEMENTS_SCHEMA],
  providers:[provideAnimationsAsync(), ConfirmationService, ConfirmationDialogService]
})
export class CoreModule { }
