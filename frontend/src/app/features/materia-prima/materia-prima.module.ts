import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ManagementRoutes } from '../../routers';
import { MateriaEditComponent } from './materia-edit/materia-edit.component';
import { MateriaQueryComponent } from './materia-query/materia-query.component';
import { MateriaNewComponent } from './materia-new/materia-new.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MenuModule } from 'primeng/menu';
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
import { DragDropModule } from 'primeng/dragdrop';
import { MultiSelectModule } from 'primeng/multiselect';
import { ButtonGroupModule } from 'primeng/buttongroup';
import { RippleModule } from 'primeng/ripple';
import { RatingModule } from 'primeng/rating';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputGroupModule } from 'primeng/inputgroup';
import { RadioButtonModule } from 'primeng/radiobutton';
import { TagModule } from 'primeng/tag';
import { StyleClassModule } from 'primeng/styleclass';
import { DropdownModule } from 'primeng/dropdown';
import { CascadeSelectModule } from 'primeng/cascadeselect';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { DialogModule } from 'primeng/dialog';
import { MateriaDetailComponent } from './materia-detail/materia-detail.component';
import { SharedModule } from '../../shared/shared.module';
import { FieldsetModule } from 'primeng/fieldset';
import { DividerModule } from 'primeng/divider';
import { AgregarIngresosComponent } from './agregar-ingresos/agregar-ingresos.component';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';


const appRoutes: Routes = [
  { path: '', redirectTo: 'query', pathMatch: 'full' },
  { path: ManagementRoutes.Query, component: MateriaQueryComponent },

  { path: `${ManagementRoutes.Detail}/:id`, component:MateriaDetailComponent  },

  { path: `${ManagementRoutes.Edit}/:id`, component:MateriaEditComponent  },

  { path: ManagementRoutes.New, component: MateriaNewComponent },

  { path: `${ManagementRoutes.Gestion}/:id`, component: MateriaDetailComponent },

  { path: `${ManagementRoutes.AddIngresos}/:id`, component: AgregarIngresosComponent },


];


@NgModule({
  declarations: [
    MateriaEditComponent,
    MateriaNewComponent,
    MateriaQueryComponent,
    AgregarIngresosComponent,
    MateriaDetailComponent,
    AgregarIngresosComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(appRoutes),

    FieldsetModule,
    DividerModule,

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
    InputGroupAddonModule,
    SharedModule
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]

})
export class MateriaPrimaModule { }
