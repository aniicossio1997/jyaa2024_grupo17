import { EstadoIngresoViewModel } from "./EstadoIngresoViewModel";
import { NameableViewModel } from "./NameableViewModel";

export interface IngresoMateriaPrimaDetailViewModel{
  id:                number;
  fecha:             number;
  descripcion:       string;
  cantidad:          number;
  codigo:            string;
  valorCompra:       number;
  materiaPrima:      NameableViewModel;
  familiaProductora: NameableViewModel;
  currentState:      NameableViewModel;
  estados:           EstadoIngresoViewModel[];
  unidadMedida: string
}
