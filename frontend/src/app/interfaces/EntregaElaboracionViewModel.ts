import ElaboracionViewModel from "./ElaboracionViewModel";
import InsumoViewModel from "./InsumoViewModel";
import { PuntoVentaViewModel } from "./PuntoVentaViewModel";
import { UsuarioViewModel } from "./UsuarioViewModel";

export interface EntregaElaboracionViewModel {
  id: number;
  cantidad: number;
  fecha: Date;
  autor: UsuarioViewModel;
  elaboracion: ElaboracionViewModel;
  puntoVenta: PuntoVentaViewModel;
}
