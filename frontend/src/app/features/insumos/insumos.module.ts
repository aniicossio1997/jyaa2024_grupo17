import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { InsumosQueryComponent } from './insumos-query/insumos-query.component';
import { ManagementRoutes } from '../../routers';
import { InsumosEditComponent } from './insumos-edit/insumos-edit.component';
import { InsumosNewComponent } from './insumos-new/insumos-new.component';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';


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
import { SharedModule } from '../../shared/shared.module';
import { FieldsetModule } from 'primeng/fieldset';
import { DividerModule } from 'primeng/divider';

import { InsumosEditIngresoComponent } from './insumos-detail/insumo-edit-ingreso/insumos-edit-ingreso.component';
import { InsumoAddIngresoComponent } from './insumos-detail/insumo-add-ingreso/insumo-add-ingreso.component';
import { InsumoDetailComponent } from './insumos-detail/insumo-detail.component';

const appRoutes: Routes = [
  { path: '', redirectTo: 'query', pathMatch: 'full' },
  { path: ManagementRoutes.Query, component: InsumosQueryComponent },

  { path: `${ManagementRoutes.Edit}/:id`, component:InsumosEditComponent  },

  { path: ManagementRoutes.New, component: InsumosNewComponent },

  { path: `${ManagementRoutes.Gestion}/:id`, component: InsumoDetailComponent },

  { path: `${ManagementRoutes.Gestion}/${ManagementRoutes.New}/:id`, component: InsumoAddIngresoComponent },

  { path: `${ManagementRoutes.Gestion}/${ManagementRoutes.Edit}/:id`, component: InsumosEditIngresoComponent },


/*


  { path: `${ManagementRoutes.AddIngresos}/:id`, component: AgregarIngresosComponent },

  { path: `${ManagementRoutes.Gestion}/${ManagementRoutes.Detail}/:id`, component: IngresoDetailComponent },

  { path: `${ManagementRoutes.Gestion}/${ManagementRoutes.Edit}/:id`, component: IngresoEditComponent },
*/

];

@NgModule({
  declarations: [
    InsumosQueryComponent,InsumosEditComponent, InsumosNewComponent,

    InsumoDetailComponent,
    InsumoAddIngresoComponent,
    InsumosEditIngresoComponent
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
export class InsumosModule { }
