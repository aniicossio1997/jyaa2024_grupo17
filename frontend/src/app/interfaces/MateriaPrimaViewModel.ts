import { NameableViewModel } from "./NameableViewModel";

export interface MateriaPrimaViewModel extends NameableViewModel {
  unidadMedida: string
  totalCantidadDisponible: number
  totalValorCompra: number
}
