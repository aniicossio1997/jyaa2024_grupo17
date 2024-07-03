import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomInputErrorDirective } from './directives/custom-input-error.directive';
import { CustomLabelDirective } from './directives/custom-label.directive';
import { DateTransformPipe } from './pipes/date-transform.pipe';
import { PriceTransformPipe } from './pipes/price-transform.pipe';



@NgModule({
  declarations: [CustomInputErrorDirective, CustomLabelDirective, DateTransformPipe, PriceTransformPipe],
  imports: [
    CommonModule
  ],
  exports:[CustomInputErrorDirective,CustomLabelDirective, DateTransformPipe, PriceTransformPipe]
})
export class SharedModule { }
