import ElaboracionViewModel from './ElaboracionViewModel';
import IngredienteViewModel from './IngredienteViewModel';
import { UsuarioViewModel } from './UsuarioViewModel';

export interface RecetaDetalleViewModel {
  id: number;
  nombre: string;
  descripcion: string;
  autor: UsuarioViewModel;
  ingredientes: IngredienteViewModel[];
  elaboraciones: ElaboracionViewModel[];
}
