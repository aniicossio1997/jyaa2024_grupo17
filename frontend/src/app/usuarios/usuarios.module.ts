import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QueryComponent } from './query/query.component';
import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
  { path: '', redirectTo: 'query', pathMatch: 'full' },
  { path: 'query', component: QueryComponent },


  /* { path: 'detalle/:idJuicio/nuevoEscrito', component: FormComponent } */
];

@NgModule({
  declarations: [
    QueryComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(appRoutes),
  ]
})
export class UsuariosModule { }
