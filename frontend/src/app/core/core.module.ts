import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShellComponent } from './shell/shell.component';
import { CoreRoutingModule } from './core-routing.module';



@NgModule({
  declarations: [
    ShellComponent
  ],
  imports: [
    CommonModule,
    CoreRoutingModule
  ],
  exports:[ShellComponent],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class CoreModule { }
