import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'priceTransform'
})
export class PriceTransformPipe implements PipeTransform {

  transform(value: number): string {
    if (!value) return '';

     // Formatear el número, usando punto para miles y coma para decimales
     const formattedValue = value
     .toFixed(2) // Asegura dos decimales
     .replace('.', ',') // Reemplaza el punto decimal por coma
     .replace(/\B(?=(\d{3})+(?!\d))/g, '.'); // Inserta puntos para los miles

    // Agregar el prefijo $ ARS
    return ` $${formattedValue}`;
  }

}
