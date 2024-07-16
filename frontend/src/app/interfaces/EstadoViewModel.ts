import { NameableViewModel } from './NameableViewModel';

export interface EstadoViewModel {
  id: number;
  fecha: number;
  autor: NameableViewModel;
  estado: string;
}
