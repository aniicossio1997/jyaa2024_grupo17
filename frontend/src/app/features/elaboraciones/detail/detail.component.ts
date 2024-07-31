import { RecetasService } from '../../../services/recetas.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ManagementRoutes } from '../../../routers';
import { RecetaDetalleViewModel } from '../../../interfaces/RecetaDetalleViewModel';
import ElaboracionDetalleViewModel from '../../../interfaces/ElaboracionDetalleViewModel';
import { ElaboracionService } from '../../../services/elaboracion.service';
import { EstadoElaboracionEnum } from '../../../model/EstadoElaboracionEnum';

@Component({
  providers: [ElaboracionService],
  selector: 'elaboracion-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css'],
})
export class DetailComponent implements OnInit {
  elaboracionDetalle: ElaboracionDetalleViewModel;
  id: number;
  loading = false;

  constructor(
    private elaboracionService: ElaboracionService,
    private router: Router,
    private toastr: ToastrService,
    private activatedRoute: ActivatedRoute
  ) {
    this.id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
  }

  ngOnInit() {
    this.elaboracionService.detail(this.id).subscribe((r) => {
      this.elaboracionDetalle = r;
    });
  }

  get autor() {
    if (!this.elaboracionDetalle) return '';
    return this.elaboracionDetalle.estados[0]?.autor.nombre;
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

  back() {
    this.router.navigate([
      '/' + ManagementRoutes.Elaboracion,
      ManagementRoutes.Query,
    ]);
  }
}
