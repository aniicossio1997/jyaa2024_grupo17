export interface IRouteModel{
  title:string,
  routerLink:string[],
  icon:string,
}

export const  ITEMS_ROUTERS:IRouteModel[]=[
  {
    title:'Usuarios',
    routerLink:['/usuarios'],
    icon:'pi-users'
  },
  {
    title:'Familia Productora',
    routerLink:['/familiaProductoras'],
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
