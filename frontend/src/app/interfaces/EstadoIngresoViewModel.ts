import { NameableViewModel } from "./NameableViewModel";

export interface EstadoIngresoViewModel{
  id:     number;
  fecha:  number;
  autor:  NameableViewModel;
  estado: string;
}
