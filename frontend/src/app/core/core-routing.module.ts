import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../auth/guards/auth.guard';
import { PublicGuard } from '../auth/guards/public.guard';
import { ShellComponent } from './shell/shell.component';
import { ManagementRoutes } from '../routers';
import { LayoutPageComponent } from '../auth/pages/layout-page/layout-page.component';

export const routesRoot: Routes = [
  {
    path: ManagementRoutes.Auth,
    loadChildren: () => import('../auth/auth.module').then((m) => m.AuthModule),
    canActivate: [PublicGuard],
  },
  {
    path: '',
    redirectTo: 'usuarios',
    pathMatch: 'full',
  },
  {
    path: '',
    component: ShellComponent,
    canActivate: [AuthGuard],
    canMatch: [AuthGuard],
    children: [
      {
        path: 'familiaProductoras',
        loadChildren: () =>
          import(
            '../features/familia-productora/familia-productora.module'
          ).then((m) => m.FamiliaProductoraModule),
      },
      {
        path: 'usuarios',
        loadChildren: () =>
          import('../features/usuarios/usuarios.module').then(
            (m) => m.UsuariosModule
          ),
      },
      {
        path: ManagementRoutes.MateriaPrima,
        loadChildren: () =>
          import('../features/materia-prima/materia-prima.module').then(
            (m) => m.MateriaPrimaModule
          ),
      },
      {
        path: ManagementRoutes.Receta,
        loadChildren: () =>
          import('../features/recetas/recetas.module').then(
            (m) => m.RecetasModule
          ),
      },
      {
        path: ManagementRoutes.Insumo,
        loadChildren: () =>
          import('../features/insumos/insumos.module').then(
            (m) => m.InsumosModule
          ),
      },
      {
        path: ManagementRoutes.Elaboracion,
        loadChildren: () =>
          import('../features/elaboraciones/elaboraciones.module').then(
            (m) => m.ElaboracionesModule
          ),
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routesRoot)],
  exports: [RouterModule],
})
export class CoreRoutingModule {}
