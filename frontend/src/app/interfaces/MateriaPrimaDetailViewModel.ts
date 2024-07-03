import { IngresoMateriaPrimaShortViewModel } from "./ingresoMateriaPrimaShortViewModel";

export  interface MateriaPrimaDetailViewModel {
  id: number;
  nombre: string;
  descripcion: string;

  unidadMedida: string
  totalCantidadDisponible: number
  totalValorCompra: number
  ingresos: IngresoMateriaPrimaShortViewModel[]
}
