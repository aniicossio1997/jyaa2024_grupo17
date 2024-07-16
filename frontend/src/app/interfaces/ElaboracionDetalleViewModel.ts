import { EstadoViewModel } from "./EstadoViewModel";

interface ElaboracionDetalleViewModel {
  id: number;
  cantidad: number;
  codigo: string;
  fecha: number; 
  recetaId: number;
  estados: EstadoViewModel[];
  estado: EstadoViewModel;
}

export default ElaboracionDetalleViewModel;