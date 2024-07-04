import { NameableViewModel } from './NameableViewModel';

export default interface RecetaViewModel extends NameableViewModel {
  descripcion: string;
  autor: string;
  ingredientes: number;
  elaboraciones: number;
}
