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
    ],
  providers: [provideHttpClient(withFetch())],
  bootstrap: [ShellComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
