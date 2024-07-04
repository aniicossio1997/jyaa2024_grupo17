import InsumoViewModel from './InsumoViewModel';
import { MateriaPrimaViewModel } from './MateriaPrimaViewModel';

export default interface IngredienteViewModel {
  id: number;
  cantidad: number;
  insumo: InsumoViewModel;
  materiaPrima: MateriaPrimaViewModel;
}
