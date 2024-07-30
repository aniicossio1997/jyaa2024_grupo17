import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LayoutPageComponent } from './pages/layout-page/layout-page.component';
import { ManagementRoutes } from '../routers';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PasswordModule } from 'primeng/password';
import { InputMaskModule } from 'primeng/inputmask';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { IconFieldModule } from 'primeng/iconfield';
import { InputIconModule } from 'primeng/inputicon';
import { InputTextModule } from 'primeng/inputtext';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { ButtonModule } from 'primeng/button';
import { StyleClassModule } from 'primeng/styleclass';
import { TooltipModule } from 'primeng/tooltip';
import { MessagesModule } from 'primeng/messages';

const appRoutes: Routes = [
  {
    path: '',
    component: LayoutPageComponent,
    children: [
      { path: 'login', component: LoginPageComponent },
      { path: '**', redirectTo: 'login' },
    ]
  }
];

@NgModule({
  declarations: [
    LayoutPageComponent,
    LoginPageComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(appRoutes),
    FormsModule,
    ReactiveFormsModule,
    PasswordModule,
    InputMaskModule,
    IconFieldModule,
    InputIconModule,
    InputTextModule,
    InputGroupModule,
    InputGroupAddonModule,
    ButtonModule,
    StyleClassModule,
    TooltipModule,
    MessagesModule
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA],
  exports:[LayoutPageComponent]
})
export class AuthModule { }
