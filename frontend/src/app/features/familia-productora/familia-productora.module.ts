import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { QueryComponent } from './query/query.component';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmPopupModule } from 'primeng/confirmpopup';
import { ToastModule } from 'primeng/toast';
import { ToolbarModule } from 'primeng/toolbar';
import { ToggleButtonModule } from 'primeng/togglebutton';
import { TableModule } from 'primeng/table';



import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TagModule } from 'primeng/tag';
import { RippleModule } from 'primeng/ripple';
import { StyleClassModule } from 'primeng/styleclass';
import { DragDropModule } from 'primeng/dragdrop';
import { DropdownModule } from 'primeng/dropdown';
import { CascadeSelectModule } from 'primeng/cascadeselect';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { DialogModule } from 'primeng/dialog';
import { RadioButtonModule } from 'primeng/radiobutton';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputNumberModule } from 'primeng/inputnumber';
import { RatingModule } from 'primeng/rating';
import { ButtonGroupModule } from 'primeng/buttongroup';
import { MultiSelectModule } from 'primeng/multiselect';
import { MenuModule } from 'primeng/menu';
import { NewComponent } from './new/new.component';
import { EditFamiliaComponent } from './edit-familia/edit-familia.component';
import { ManagementRoutes } from '../../routers';
import { SharedModule } from '../../shared/shared.module';

const appRoutes: Routes = [
  { path: '', redirectTo: 'query', pathMatch: 'full' },

  { path: `${ManagementRoutes.Edit}/:id`, component: EditFamiliaComponent, title: "Editar Familia Productora" },
  { path: ManagementRoutes.Query, component: QueryComponent, title: "Listado de Familias Productoras" },
  { path: ManagementRoutes.New, component: NewComponent, title: "Agregar Familia Productora" },


];

@NgModule({
  declarations: [QueryComponent, NewComponent, EditFamiliaComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(appRoutes),

    ButtonModule,
    CardModule,
    InputTextModule,
    InputTextareaModule,
    ConfirmDialogModule,
    ConfirmPopupModule,
    ToastModule,
    ToolbarModule,
    ToggleButtonModule,
    TableModule,
    DragDropModule,
    FormsModule,
    ReactiveFormsModule,
    TagModule,
    StyleClassModule,
    DropdownModule,
    CascadeSelectModule,
    DynamicDialogModule,
    DialogModule,
    RadioButtonModule,
    InputGroupModule,
    InputNumberModule,
    RatingModule,
    RippleModule,
    ButtonGroupModule,
    MultiSelectModule,
    MenuModule,
    ReactiveFormsModule,
    SharedModule
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class FamiliaProductoraModule { }