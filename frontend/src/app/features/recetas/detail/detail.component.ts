import { RecetasService } from '../../../services/recetas.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ManagementRoutes } from '../../../routers';
import { RecetaDetalleViewModel } from '../../../interfaces/RecetaDetalleViewModel';
import { EstadoViewModel } from '../../../interfaces/EstadoViewModel';
import { EstadoIngresoEnums } from '../../../model/EstadoIngresoEnums';
import { EstadoElaboracionEnum } from '../../../model/EstadoElaboracionEnum';

interface IngredienteNormal {
  cantidad: number;
  nombre: string;
  tipo: string;
  unidadMedida: string;
  cantidadDisponible: number;
}

@Component({
  providers: [RecetasService],
  selector: 'receta-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css'],
})
export class DetailComponent implements OnInit {
  receta: RecetaDetalleViewModel;
  ingredientesNormal: IngredienteNormal[];
  id: number;
  loading = false;

  constructor(
    private recetasService: RecetasService,
    private router: Router,
    private toastr: ToastrService,
    private activatedRoute: ActivatedRoute
  ) {
    this.id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
  }

  ngOnInit() {
    this.recetasService.detail(this.id).subscribe((res) => {
      this.receta = res;
      this.ingredientesNormal = this.receta.ingredientes.map((i) => ({
        cantidad: i.cantidad,
        nombre: i.insumo?.nombre || i.materiaPrima?.nombre,
        unidadMedida: i.materiaPrima?.unidadMedida || i.insumo?.unidadMedida,
        tipo: i.insumo ? 'INSUMO' : 'MATERIA PRIMA',
        cantidadDisponible:
          i.insumo?.cantidadDisponible ||
          i.materiaPrima?.totalCantidadDisponible ||
          0,
      }));
    });
  }

  getEstadoSeverity(estado: string) {
    switch (estado) {
      case EstadoElaboracionEnum.ENTREGADO_COMPLETO:
        return 'success';
      case EstadoElaboracionEnum.ENTREGADO_PARCIAL:
        return 'primary';
      case EstadoElaboracionEnum.EN_DEPOSITO:
        return 'warning';
      case EstadoElaboracionEnum.EN_PROCESO:
        return 'info';
    }
    return '';
  }

  public get Routes() {
    return {
      EDIT: `/${ManagementRoutes.Receta}/${ManagementRoutes.Edit}/${this.receta?.id}`,
      ELABORACION_NEW: `/${ManagementRoutes.Receta}/${this.receta?.id}/${ManagementRoutes.Elaboracion}`,

    };
  }

  back() {
    this.router.navigate([
      '/' + ManagementRoutes.Receta,
      ManagementRoutes.Query,
    ]);
  }
}
