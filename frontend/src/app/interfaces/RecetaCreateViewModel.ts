import IngredienteCreateViewModel from "./IngredienteCreateViewModel";

export default interface RecetaCreateViewModel {
  nombre: string;
  descripcion: string;
  ingredientes: Omit<IngredienteCreateViewModel, 'recetaId'>[];
}
