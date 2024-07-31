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
import { InputTextareaModule } from 'primeng/inputtextarea';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmPopupModule } from 'primeng/confirmpopup';
import { DialogModule } from 'primeng/dialog';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { CheckboxModule } from 'primeng/checkbox';
import { DetailComponent } from './detail/detail.component';
import { NewComponent } from './new/new.component';
import { DividerModule } from 'primeng/divider';
import { ListboxModule } from 'primeng/listbox';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { EditComponent } from './edit/edit.component';
import { ManagementRoutes } from '../../routers';
import { SelectorIngresosComponent } from '../elaboraciones/selector-ingresos/selector-ingresos.component';

const appRoutes: Routes = [
  { path: '', redirectTo: 'query', pathMatch: 'full' },
  { path: 'query', component: QueryComponent, title: 'Listado de Recetas' },
  { path: 'new', component: NewComponent, title: 'Agregar Receta' },
  {
    path: 'detail/:id',
    component: DetailComponent,
    title: 'Detalle de Receta',
  },
  { path: 'edit/:id', component: EditComponent, title: 'Editar Receta' },
 
];

@NgModule({
  declarations: [
    QueryComponent,
    DetailComponent,
    NewComponent,
    EditComponent,
  ],
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
    InputTextareaModule,
    DropdownModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
    CheckboxModule,
    DividerModule,
    ListboxModule,
    InputNumberModule,
    InputGroupModule,
    InputGroupAddonModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class RecetasModule {}
