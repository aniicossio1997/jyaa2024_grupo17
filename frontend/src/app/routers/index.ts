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

  Usuario='usuarios',
  FamiliaProductora='familiaProductoras',
  MateriaPrima='materiaPrimas',
  Insumo='Insumos',
  Receta='Recetas'

}
export enum Routes {
  AppRoot = '',
  Login = 'login',

}

export const  ITEMS_ROUTERS:IRouteModel[]=[
  {
    title:'Usuarios',
    routerLink:[`/${ManagementRoutes.Usuario}`],
    icon:'pi-users'
  },
  {
    title:'Familia Productora',
    routerLink:[`/${ManagementRoutes.FamiliaProductora}`],
    icon:'pi-address-book'
  },
  {
    title:'Materia Prima',
    routerLink:['/'],
    icon:'pi-folder'
  },
  {
    title:'Insumo',
    routerLink:['/'],
    icon:'pi-folder'
  },
  {
    title:'Recetas',
    routerLink:['/'],
    icon:'pi-folder'
  },


  //------------------------------------

]


