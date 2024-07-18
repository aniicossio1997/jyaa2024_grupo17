export interface IRouteModel{
  title:string,
  routerLink:string[],
  icon:string,
}
export enum ManagementRoutes {
  Query = 'query',
  New = 'new',
  Edit = 'edit',
  Detail = 'detail',
  AddIngredientes='add-ingredientes',
  AddIngresos='add-ingresos',
  Gestion='gestion',
  




  Usuario='usuarios',
  FamiliaProductora='familiaProductoras',
  MateriaPrima='materiaPrimas',
  Insumo='Insumos',
  Receta='recetas',
  Elaboracion='elaboracion',

}
export enum Routes {
  AppRoot = '',
  Login = 'login',

}

export const  ITEMS_ROUTERS:IRouteModel[]=[
  {
    title:'Usuarios',
    routerLink:[`/${ManagementRoutes.Usuario}`],
    icon:'fa-solid fa-user-group'
  },
  {
    title:'Familias Productoras',
    routerLink:[`/${ManagementRoutes.FamiliaProductora}`],
    icon:'fa-solid fa-tractor'
  },
  {
    title:'Materia Prima',
    routerLink:[`/${ManagementRoutes.MateriaPrima}`],
    icon:'fa-solid fa-wheat-awn'
  },
  {
    title:'Insumos',
    routerLink:[`/${ManagementRoutes.Insumo}`],
    icon:'fa-solid fa-clipboard-list'
  },
  {
    title:'Recetas',
    routerLink:[`/${ManagementRoutes.Receta}`],
    icon:'fa-solid fa-kitchen-set'
  },


  //------------------------------------

]


