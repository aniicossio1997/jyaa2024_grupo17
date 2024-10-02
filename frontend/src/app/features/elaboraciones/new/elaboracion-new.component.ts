import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RecetasService } from '../../../services/recetas.service';
import { RecetaDetalleViewModel } from '../../../interfaces/RecetaDetalleViewModel';
import IngredienteViewModel from '../../../interfaces/IngredienteViewModel';
import { MateriaPrimaDetailViewModel } from '../../../interfaces/MateriaPrimaDetailViewModel';
import { UnidadMedidaEnum } from '../../../interfaces/UnidadMedidaEnum';
import { ActivatedRoute, Router } from '@angular/router';
import { ManagementRoutes } from '../../../routers';
import { SelectorIngresosComponent } from '../selector-ingresos/selector-ingresos.component';
import { EstadoElaboracionEnum } from '../../../model/EstadoElaboracionEnum';
import { ElaboracionService } from '../../../services/elaboracion.service';
import { ElaboracionCreateViewModel } from '../../../interfaces/ElaboracionCreateViewModel';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-insumos-new',
  templateUrl: './elaboracion-new.component.html',
  providers: [
    RecetasService,
    MateriaPrimaService,
    DialogService,
    ElaboracionService,
  ],
})
export class ElaboracionNewComponent implements OnInit {
  recetaId: number;
  receta: RecetaDetalleViewModel;
  insumos: IngredienteViewModel[];
  materiasPrimas: IngredienteViewModel[];
  detalleMateriaPrima: Map<number, MateriaPrimaDetailViewModel> = new Map();
  consumosMateriaPrima: Map<
    number,
    { ingresoMateriaPrimaId: number; cantidad: number }[]
  > = new Map();

  form: FormGroup;

  unidadMedidaArray: string[] = Object.keys(UnidadMedidaEnum);
  estados: string[] = Object.keys(EstadoElaboracionEnum);
  loading: boolean = false;
  ref: DynamicDialogRef | undefined;

  // errores

  insumosInsuficientes = false;
  materiasPrimasInsuficientes = false;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private recetaService: RecetasService,
    private materiasPrimaService: MateriaPrimaService,
    private activatedRoute: ActivatedRoute,
    private dialogService: DialogService,
    private elaboracionService: ElaboracionService,
    private toastr: ToastrService
  ) {
    this.initForm();
    this.consumosMateriaPrima = new Map();
    this.recetaId = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
  }

  ngOnInit(): void {
    this.recetaService.detail(this.recetaId).subscribe((res) => {
      this.receta = res;
      this.insumos = res.ingredientes.filter((i) => i.insumo != null);
      this.materiasPrimas = res.ingredientes.filter(
        (i) => i.materiaPrima != null
      );

      this.materiasPrimas.forEach((mp) => {
        this.materiasPrimaService.getById(mp.materiaPrima.id).subscribe((r) => {
          this.detalleMateriaPrima.set(r.id, r);
          console.log(r, mp.cantidad)
          if (r.totalCantidadDisponible < mp.cantidad) {
            this.materiasPrimasInsuficientes = true;
          }
        });
      });

      if (this.insumos.some((i) => i.cantidad > i.insumo.cantidadDisponible)) {
        this.insumosInsuficientes = true;
      }
    });
  }

  initForm() {
    this.form = this.fb.group({
      cantidad: [1, Validators.required],
      estado: EstadoElaboracionEnum.EN_PROCESO,
      nota: [''],
    });
  }

  cancel() {
    this.router.navigate(['/' + ManagementRoutes.Elaboracion]);
  }
  save() {
    const raw = this.form.getRawValue();
    const consumoMateriasPrimas = Array.from(
      this.consumosMateriaPrima.values()
    );
    const request: ElaboracionCreateViewModel = {
      cantidad: raw.cantidad,
      estado: raw.estado,
      fecha: new Date(),
      nota: raw.nota,
      recetaId: this.recetaId,
      consumoMateriasPrimas: consumoMateriasPrimas.flat(),
    };
    this.loading = true;
    this.elaboracionService.create(request).subscribe((res) => {
      this.loading = false;
      this.toastr.success('Se ha creado la elaboración!');
      this.router.navigate([
        '/' +
          ManagementRoutes.Elaboracion +
          '/' +
          ManagementRoutes.Detail +
          '/' +
          res.id,
      ]);
    });
  }

  getMin(a: number, b: number): number {
    return Math.min(a, b);
  }

  getCantidad(item: IngredienteViewModel) {
    return (item.cantidad * (this.form.get('cantidad')?.value ?? 0)).toFixed(1);
  }

  onIngresosSelected(
    materiaPrimaId: number,
    data: { ingresoMateriaPrimaId: number; cantidad: number }[]
  ) {
    this.consumosMateriaPrima.set(materiaPrimaId, data);
  }

  openSelectorIngresos(item: IngredienteViewModel) {
    const callbackFunction = this.onIngresosSelected.bind(this);
    this.ref = this.dialogService.open(SelectorIngresosComponent, {
      header: 'Seleccionar ingresos de ' + item.materiaPrima.nombre,
      width: '50vw',
      closable: false,
      contentStyle: { overflow: 'visible' },
      data: {
        materiaPrima: item.materiaPrima,
        cantidadRequerida: this.getCantidad(item),
        initialData: this.consumosMateriaPrima.get(item.materiaPrima.id),
        callback: callbackFunction,
      },
    });

    this.ref.onClose.subscribe((data: any) => {});
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
  get invalid() {
    return;
  }
}
