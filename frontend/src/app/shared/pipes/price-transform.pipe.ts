import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'priceTransform'
})
export class PriceTransformPipe implements PipeTransform {

  transform(value: number): string {
    if (!value) return '';

    // Formatear el número como precio con dos decimales
    const formattedValue = value.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');

    // Agregar el prefijo $ ARS
    return ` $ ARS ${formattedValue}`;
  }

}
