import { RolUsuario } from '../model/RolUsuario';
import { NameableViewModel } from './NameableViewModel';

export interface UsuarioViewModel extends NameableViewModel {
  apellido: string;
  rol: RolUsuario;
  email: string;
  username: string;
  password: string;
}
