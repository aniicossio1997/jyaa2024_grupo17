import { NameableViewModel } from "./NameableViewModel"

export interface IngresoMateriaPrimaShortViewModel{
  id: number
  fecha: number
  descripcion: string
  cantidad: number
  codigo: string
  valorCompra: number
  materiaPrima: NameableViewModel
  familiaProductora: NameableViewModel

  currentState: NameableViewModel
}
