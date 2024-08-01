import { IngresoMateriaPrimaDetailViewModel } from "./IngresoMateriaPrimaDetailViewModel";
import { UnidadMedidaEnum } from "./UnidadMedidaEnum";

export default interface ConsumoMateriaPrimaViewModel {
  id: number;
  cantidad: number;
  ingresoMateriaPrima: IngresoMateriaPrimaDetailViewModel;
  elaboracionId: number;
  unidadMedida: UnidadMedidaEnum;
}
