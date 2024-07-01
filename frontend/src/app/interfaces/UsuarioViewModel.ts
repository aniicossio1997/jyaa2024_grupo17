import { NameableViewModel } from './NameableViewModel';

export interface UsuarioViewModel extends NameableViewModel {
  apellido: string;
  rol: string;
  email: string;
  username: string;
}
