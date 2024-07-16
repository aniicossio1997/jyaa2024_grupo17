import { EstadoViewModel } from "./EstadoViewModel";

interface ElaboracionViewModel {
  id: number;
  cantidad: number;
  codigo: string;
  fecha: number; 
  recetaId: number;
  estado: EstadoViewModel;
}

export default ElaboracionViewModel;
