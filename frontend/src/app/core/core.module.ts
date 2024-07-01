import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShellComponent } from './shell/shell.component';
import { CoreRoutingModule } from './core-routing.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';



@NgModule({
  declarations: [
    ShellComponent,

  ],
  imports: [
    CommonModule,
    CoreRoutingModule,
    SidebarComponent,

  ],
  exports:[ShellComponent],
  schemas:[CUSTOM_ELEMENTS_SCHEMA],
  providers:[provideAnimationsAsync(),]
})
export class CoreModule { }
