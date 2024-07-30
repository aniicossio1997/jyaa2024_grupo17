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
import { AuthModule } from '../auth/auth.module';
import { LayoutPublicShellComponent } from './layout/layout-public-shell/layout-public-shell.component';
import { SharedModule } from '../shared/shared.module';
import { BreadcrumbCustomComponent } from './breadcrumb-custom/breadcrumb-custom.component';

@NgModule({
  declarations: [
    ShellComponent,
    LayoutPublicShellComponent,
    BreadcrumbCustomComponent,

  ],
  imports: [
    CommonModule,
    CoreRoutingModule,
    SidebarComponent,
    BreadcrumbModule,
    ConfirmDialogModule,
    AuthModule,

  ],
  exports:[ShellComponent, LayoutPublicShellComponent],
  schemas:[CUSTOM_ELEMENTS_SCHEMA],
  providers:[provideAnimationsAsync(), ConfirmationService, ConfirmationDialogService]
})
export class CoreModule { }
