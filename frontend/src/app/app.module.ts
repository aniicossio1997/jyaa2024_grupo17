import {  CUSTOM_ELEMENTS_SCHEMA, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { FormsModule } from '@angular/forms';

import { CoreModule } from './core/core.module';
import { CommonModule } from '@angular/common';
import { HTTP_INTERCEPTORS, provideHttpClient, withFetch, withInterceptorsFromDi } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { CoreRoutingModule } from './core/core-routing.module';
import { ShellComponent } from './core/shell/shell.component';
import { LayoutPublicShellComponent } from './core/layout/layout-public-shell/layout-public-shell.component';
import { AuthInterceptor } from './interceptors/AuthInterceptor.interceptor';
import { registerLocaleData } from '@angular/common';
import localeEs from '@angular/common/locales/es';


registerLocaleData(localeEs, 'es-ES');


@NgModule({
  declarations: [
  ],
  imports: [
    BrowserAnimationsModule,
    CommonModule,
    BrowserModule,
    ButtonModule,
    CardModule,
    FormsModule,
    CoreModule,
    //AuthModule,

    //CoreRoutingModule,
    ToastrModule.forRoot({
      timeOut: 4000,
      positionClass: "toast-top-right",
      progressBar: true,
      progressAnimation: "increasing",
      closeButton:true
    }),
    ],
  providers: [
    provideHttpClient(withInterceptorsFromDi()),
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },{
      provide: LOCALE_ID, useValue: 'es-ES'
    }

  ],
  bootstrap: [LayoutPublicShellComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],

})
export class AppModule { }
