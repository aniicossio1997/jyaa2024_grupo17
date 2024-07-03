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
import { EditComponent } from './edit/edit.component';
import { SharedModule } from '../../shared/shared.module';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmPopupModule } from 'primeng/confirmpopup';
import { DialogModule } from 'primeng/dialog';
import { DynamicDialogModule } from 'primeng/dynamicdialog';

const appRoutes: Routes = [
  { path: '', redirectTo: 'query', pathMatch: 'full' },
  { path: 'query', component: QueryComponent },
  { path: 'new', component: NewComponent },
  { path: 'edit/:id', component: EditComponent },

  /* { path: 'detalle/:idJuicio/nuevoEscrito', component: FormComponent } */
];

@NgModule({
  declarations: [QueryComponent, NewComponent, EditComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(appRoutes),
    TableModule,
    ButtonModule,
    MenuModule,
    ToastModule,
    TagModule,
    ConfirmDialogModule,
    ConfirmPopupModule,
    InputIconModule,
    InputTextModule,
    IconFieldModule,
    DialogModule,
    DynamicDialogModule,
    RouterModule,
    InputTextareaModule,
    DropdownModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class UsuariosModule {}
