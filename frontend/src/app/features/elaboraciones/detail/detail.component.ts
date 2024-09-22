import { RecetasService } from '../../../services/recetas.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ManagementRoutes } from '../../../routers';
import { RecetaDetalleViewModel } from '../../../interfaces/RecetaDetalleViewModel';
import ElaboracionDetalleViewModel from '../../../interfaces/ElaboracionDetalleViewModel';
import { ElaboracionService } from '../../../services/elaboracion.service';
import { EstadoElaboracionEnum } from '../../../model/EstadoElaboracionEnum';
import { NotaDialogComponent } from '../nota-dialog/nota-dialog.component';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import ConfirmationDialogService from '../../../core/ConfirmationDialogService';
import { NotaService } from '../../../services/nota.service';
import { ElaboracionCambiarEstadoComponent } from '../elaboracion-cambiar-estado/elaboracion-cambiar-estado.component';
import { ElaboracionRegistrarEntregaComponent } from '../elaboracion-registrar-entrega/elaboracion-regsitrar-entrega.component';

interface ConsumoNormal {
  cantidad: number;
  unidadMedida: string;
  ingrediente: string;
  familiaProductora: string;
  ingresoCodigo: string;
  ingresoFecha: number;
  tipo: string;
}

@Component({
  providers: [
    ElaboracionService,
    DialogService,
    ConfirmationDialogService,
    NotaService,
  ],
  selector: 'elaboracion-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css'],
})
export class DetailComponent implements OnInit {
  elaboracionDetalle: ElaboracionDetalleViewModel;
  id: number;
  loading = false;
  consumos: ConsumoNormal[] = [];
  totalEntregado = 0;
  ref: DynamicDialogRef | undefined;
  constructor(
    private elaboracionService: ElaboracionService,
    private router: Router,
    private toastr: ToastrService,
    private activatedRoute: ActivatedRoute,
    private dialogService: DialogService,
    private confirmationDialogService: ConfirmationDialogService,
    private notaService: NotaService
  ) {
    this.id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
  }

  ngOnInit() {
    this.init();
  }

  get autor() {
    if (!this.elaboracionDetalle) return '';
    return this.elaboracionDetalle.estados[0]?.autor.nombre;
  }

  openNotaForm() {
    const callbackFunction = this.init.bind(this);
    this.ref = this.dialogService.open(NotaDialogComponent, {
      header: 'Agregar Nota',
      width: '50vw',
      breakpoints: {
        '960px': '75vw',
        '640px': '90vw',
      },
      closable: false,
      contentStyle: { overflow: 'visible' },
      data: {
        callback: callbackFunction,
        elaboracionId: this.elaboracionDetalle.id,
      },
    });

    this.ref.onClose.subscribe((data: any) => {});
  }

  openCambiarEstado() {
    const callbackFunction = this.init.bind(this);
    this.ref = this.dialogService.open(ElaboracionCambiarEstadoComponent, {
      header: 'Cambiar estado de la elaboración',
      width: '30vw',
      breakpoints: {
        '960px': '75vw',
        '640px': '90vw',
      },
      closable: false,
      contentStyle: { overflow: 'visible' },
      data: {
        callback: callbackFunction,
        elaboracionId: this.elaboracionDetalle.id,
        estadoInicial: this.elaboracionDetalle.estado.estado,
      },
    });

    this.ref.onClose.subscribe((data: any) => {});
  }

  openRegistrarEntrega() {
    const callbackFunction = this.init.bind(this);
    this.ref = this.dialogService.open(ElaboracionRegistrarEntregaComponent, {
      header: 'Registrar Entrega',
      width: '30vw',
      breakpoints: {
        '960px': '75vw',
        '640px': '90vw',
      },
      closable: false,
      contentStyle: { overflow: 'visible' },
      data: {
        callback: callbackFunction,
        elaboracion: this.elaboracionDetalle,
      },
    });

    this.ref.onClose.subscribe((data: any) => {
      this.init();
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

  init() {
    this.elaboracionService.detail(this.id).subscribe((r) => {
      this.elaboracionDetalle = r;
      const consumosMateriaPrima: ConsumoNormal[] = r.consumosMateriaPrima.map(
        (c) => ({
          cantidad: c.cantidad,
          unidadMedida: c.unidadMedida,
          ingresoCodigo: c.ingresoMateriaPrima.codigo,
          tipo: 'MATERIA PRIMA',
          ingrediente: c.ingresoMateriaPrima.materiaPrima.nombre,
          familiaProductora: c.ingresoMateriaPrima.familiaProductora.nombre,
          ingresoFecha: c.ingresoMateriaPrima.fecha,
        })
      );
      const consumosInsumo: ConsumoNormal[] = r.consumosInsumo.map((c) => ({
        cantidad: c.cantidad,
        unidadMedida: c.insumo.unidadMedida,
        tipo: 'INSUMO',
        ingresoCodigo: null,
        ingrediente: c.insumo.nombre,
        familiaProductora: null,
        ingresoFecha: null,
      }));

      this.consumos = [...consumosMateriaPrima, ...consumosInsumo];
      this.totalEntregado = r.entregas.reduce(
        (total, entrega) => total + entrega.cantidad,
        0
      );
    });
  }

  deleteNota(item) {
    const callbackFunction = this.init.bind(this);
    this.confirmationDialogService.confirmDelete(
      `¿Está seguro que desea eliminar la nota?`,
      () => {
        console.log(item);
        this.notaService.delete(item.id).subscribe(() => {
          this.toastr.success('Se ha eliminado la nota!');
          callbackFunction();
        });
      }
    );
  }

  back() {
    this.router.navigate([
      '/' + ManagementRoutes.Elaboracion,
      ManagementRoutes.Query,
    ]);
  }
}
