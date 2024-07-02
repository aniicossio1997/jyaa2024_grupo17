import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QueryComponent } from './query/query.component';
import { NewComponent } from './new/new.component';
import { EditComponent } from './edit/edit.component';
import { FormIngresoComponent } from './form-ingreso/form-ingreso.component';



@NgModule({
  declarations: [
    QueryComponent,
    NewComponent,
    EditComponent,
    FormIngresoComponent
  ],
  imports: [
    CommonModule
  ]
})
export class MateriaPrimaModule { }
