import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ManagementRoutes } from '../routers';

const routes: Routes = [
  { path: '', redirectTo: 'familiaProductoras', pathMatch: 'full' },
  {
    path: 'familiaProductoras',
    loadChildren: () => import('../familia-productora/familia-productora.module').then(m => m.FamiliaProductoraModule)
  },
  {
    path: 'usuarios',
    loadChildren: () => import('./../usuarios/usuarios.module').then(m => m.UsuariosModule)
  },
  {
    path: ManagementRoutes.MateriaPrima,
    loadChildren: () => import('./../materia-prima/materia-prima.module').then(m => m.MateriaPrimaModule)
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CoreRoutingModule {
}

