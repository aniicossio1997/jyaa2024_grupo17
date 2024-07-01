import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

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

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CoreRoutingModule {
}

