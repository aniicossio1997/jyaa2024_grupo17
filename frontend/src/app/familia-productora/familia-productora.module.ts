import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { QueryComponent } from './query/query.component';


const appRoutes: Routes = [
  { path: '', redirectTo: 'query', pathMatch: 'full' },
  { path: 'query', component: QueryComponent },


  /* { path: 'detalle/:idJuicio/nuevoEscrito', component: FormComponent } */
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(appRoutes),
  ]
})
export class FamiliaProductoraModule { }
