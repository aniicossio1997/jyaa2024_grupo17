import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
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
import { DividerModule } from 'primeng/divider';
import { ListboxModule } from 'primeng/listbox';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { DetailComponent } from './detail/detail.component';

const appRoutes: Routes = [
  { path: '', redirectTo: 'query', pathMatch: 'full' },
  { path: 'detail/:id', component: DetailComponent , title: "Detalle de Elaboracion" },
];

@NgModule({
  declarations: [DetailComponent],
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
export class ElaboracionesModule {}
