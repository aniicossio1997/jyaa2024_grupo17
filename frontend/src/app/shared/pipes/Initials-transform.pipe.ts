import { Pipe, type PipeTransform } from '@angular/core';

@Pipe({
  name: 'initialsTransform',
})
export class InitialsTransformPipe implements PipeTransform {

  transform(value: string): string {
    if (!value || value.trim().length === 0) return ''; // Maneja valores vacíos o solo espacios

    const words = value.trim().split(/\s+/); // Usa expresión regular para dividir por múltiples espacios
    if (words.length === 0) return '';

    if (words.length === 1) {
      // Solo una palabra: devuelve la inicial en mayúscula
      return words[0][0].toUpperCase();
    }
         // Dos o más palabras: devuelve las iniciales en mayúscula
         const initials = words[0][0] + words[1][0];
         return initials.toUpperCase();
    ;
  }

}
