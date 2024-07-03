import {  CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { FormsModule } from '@angular/forms';

import { ShellComponent } from './core/shell/shell.component';
import { CoreModule } from './core/core.module';
import { CommonModule } from '@angular/common';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,
    BrowserModule,
    ButtonModule,
    CardModule,
    FormsModule,
    CoreModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      timeOut: 4000,
      positionClass: "toast-top-right",
      progressBar: true,
      progressAnimation: "increasing",
      closeButton:true
    }),
    ],
  providers: [provideHttpClient(withFetch())],
  bootstrap: [ShellComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],

})
export class AppModule { }
