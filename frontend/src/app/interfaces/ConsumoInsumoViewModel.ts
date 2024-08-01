import InsumoViewModel from "./InsumoViewModel";

export interface ConsumoInsumoViewModel {
  id: number;
  cantidad: number;
  insumo: InsumoViewModel;
  elaboracionId: number;
}
