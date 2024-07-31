import { EstadoElaboracionEnum } from "../model/EstadoElaboracionEnum";

export interface ElaboracionCreateViewModel {
    fecha: Date;
    cantidad: number; 
    estado: EstadoElaboracionEnum;
    recetaId: number; 
    nota?: string;
    consumoMateriasPrimas: {ingresoMateriaPrimaId: number, cantidad: number }[];
  }