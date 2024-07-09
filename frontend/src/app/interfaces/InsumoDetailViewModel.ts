import { IngresoMateriaPrimaShortViewModel } from './ingresoMateriaPrimaShortViewModel';

export interface InsumoDetailViewModel {
  id: number;
  nombre: string;
  descripcion: string;
  unidadMedida: string;
  totalCantidadDisponible: number;
  totalValorCompra: number;
}
