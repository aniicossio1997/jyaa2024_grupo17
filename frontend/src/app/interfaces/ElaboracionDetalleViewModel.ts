import { ConsumoInsumoViewModel } from "./ConsumoInsumoViewModel";
import ConsumoMateriaPrimaViewModel from "./ConsumoMateriaPrimaViewModel";
import { EntregaElaboracionViewModel } from "./EntregaElaboracionViewModel";
import { EstadoViewModel } from "./EstadoViewModel";
import NotaViewModel from "./NotaViewModel";

interface ElaboracionDetalleViewModel {
  id: number;
  cantidad: number;
  codigo: string;
  fecha: number; 
  recetaId: number;
  estados: EstadoViewModel[];
  estado: EstadoViewModel;
  consumosMateriaPrima: ConsumoMateriaPrimaViewModel[];
  consumosInsumo: ConsumoInsumoViewModel[];
  entregas: EntregaElaboracionViewModel[];
  notas: NotaViewModel[];
}

export default ElaboracionDetalleViewModel;