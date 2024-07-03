import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateTransformPipe'
})
export class DateTransformPipe implements PipeTransform {

  transform(value: number, ...args: any[]): string {
    if (!value) return '';

    // Convertir el valor en una fecha
    const date = new Date(value);



    // Formatear la fecha como dd/MM/yyyy
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0'); // getMonth() es 0-indexado
    const year = date.getFullYear();

    return ` ${day}/${month}/${year}`;
  }

}
