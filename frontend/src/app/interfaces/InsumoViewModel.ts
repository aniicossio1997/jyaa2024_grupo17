import { NameableViewModel } from './NameableViewModel';

export default interface InsumoViewModel extends NameableViewModel {
  descripcion: string;
  unidadMedida: string;
  cantidadDisponible: number;
  totalValorCompra: number;
}
