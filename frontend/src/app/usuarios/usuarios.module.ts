import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QueryComponent } from './query/query.component';
import { RouterModule, Routes } from '@angular/router';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { MenuModule } from 'primeng/menu';
import { ToastModule } from 'primeng/toast';
import { TagModule } from 'primeng/tag';
import { InputIconModule } from 'primeng/inputicon';
import { InputTextModule } from 'primeng/inputtext';
import { IconFieldModule } from 'primeng/iconfield';
import { NewComponent } from './new/new.component';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const appRoutes: Routes = [
  { path: '', redirectTo: 'query', pathMatch: 'full' },
  { path: 'query', component: QueryComponent },
  { path: 'new', component: NewComponent },


  /* { path: 'detalle/:idJuicio/nuevoEscrito', component: FormComponent } */
];

@NgModule({
  declarations: [
    QueryComponent,
    NewComponent,
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(appRoutes),
    TableModule,
    ButtonModule,
    MenuModule,
    ToastModule,
    TagModule,
    InputIconModule,
    InputTextModule,
    IconFieldModule,
    RouterModule,
    InputTextareaModule,
    DropdownModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class UsuariosModule { }
