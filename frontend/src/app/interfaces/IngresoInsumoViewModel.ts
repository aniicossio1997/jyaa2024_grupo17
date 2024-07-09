import { NameableViewModel } from "./NameableViewModel";

export interface IngresoInsumoViewModel{
  id:          number;
  fecha:       number;
  descripcion: string;
  cantidad:    number;
  codigo:      string;
  valorCompra: number;
  insumo:      NameableViewModel;
  unidadMedida:string
}
