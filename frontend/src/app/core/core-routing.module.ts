import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ManagementRoutes } from '../routers';
import { BreadcrumbModule } from 'primeng/breadcrumb';

export const routesRoot: Routes = [
  { path: '', redirectTo: 'usuarios', pathMatch: 'full' },
  {
    path: 'familiaProductoras',
    loadChildren: () => import('../features/familia-productora/familia-productora.module').then(m => m.FamiliaProductoraModule)
  },
  {
    path: 'usuarios',
    loadChildren: () => import('../features/usuarios/usuarios.module').then(m => m.UsuariosModule)
  },
  {
    path: ManagementRoutes.MateriaPrima,
    loadChildren: () => import('../features/materia-prima/materia-prima.module').then(m => m.MateriaPrimaModule)
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routesRoot)],
  exports: [RouterModule]
})
export class CoreRoutingModule {
}

