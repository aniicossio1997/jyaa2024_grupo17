import { UsuarioViewModel } from "./UsuarioViewModel";

export default interface NotaViewModel {
  id: number;
  fecha: Date;
  descripcion: string;
  autor: UsuarioViewModel;
}
