import { EntregaElaboracionService } from './../../../services/entrega-elaboracion-service';
import { EstadoElaboracionService } from './../../../services/estado-elaboracion.service';
import { Component } from '@angular/core';
import {
  DialogService,
  DynamicDialogConfig,
  DynamicDialogRef,
} from 'primeng/dynamicdialog';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  ValidatorFn,
  Validators,
} from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import ElaboracionViewModel from '../../../interfaces/ElaboracionViewModel';
import { PuntoVentaService } from '../../punto-venta/punto-venta.service';
import ElaboracionDetalleViewModel from '../../../interfaces/ElaboracionDetalleViewModel';
import { PuntoVentaViewModel } from '../../../interfaces/PuntoVentaViewModel';

@Component({
  selector: 'app-elaboracion-registrar-entrega',
  templateUrl: './elaboracion-registrar-entrega.component.html',
  providers: [DialogService, EntregaElaboracionService, PuntoVentaService],
})
export class ElaboracionRegistrarEntregaComponent {
  elaboracion: ElaboracionDetalleViewModel;
  myForm: FormGroup;
  callback: () => void;
  msjError: string = undefined;
  currentDate = new Date();
  maxCantidad = 0;
  loading = false;
  puntosVenta: PuntoVentaViewModel[] = [];
  bloquear = false;

  constructor(
    private dialogService: DialogService,
    private ref: DynamicDialogRef,
    private fb: FormBuilder,
    private config: DynamicDialogConfig,
    private toastr: ToastrService,
    private entregaElaboracionService: EntregaElaboracionService,
    private puntoVentaService: PuntoVentaService
  ) {}

  ngOnInit() {
    this.elaboracion = this.config.data.elaboracion;

    this.callback = this.config.data.callback;

    // Cantidad total - entregada hasta ahora
    this.maxCantidad =
      this.elaboracion.cantidad -
      this.elaboracion.entregas.reduce(
        (total, entrega) => total + entrega.cantidad,
        0
      );

    this.bloquear = this.maxCantidad <= 0 || true;
    this.initForm();
    this.puntoVentaService.get().subscribe((res) => (this.puntosVenta = res));
  }

  positiveNumberValidator: ValidatorFn = (
    control: AbstractControl
  ): { [key: string]: any } | null => {
    const value = control.value;
    if (isNaN(value) || value < 0) {
      return { positiveNumber: { value: control.value } };
    }
    return null;
  };

  cancel() {
    this.ref.close();
  }
  save() {
    this.msjError = undefined;
    this.loading = true;
    this.entregaElaboracionService
      .create({
        cantidad: this.myForm.get('cantidad').value,
        updateState: this.myForm.get('updateState').value,
        elaboracionId: this.elaboracion.id,
        puntoVentaId: this.myForm.get('puntoVentaId').value,
        fecha: this.myForm.get('fecha').value,
      })
      .subscribe((data) => {
        this.loading = false;
        this.toastr.success('Se ha registrado la entrega!');
        this.cancel();
        this.callback();
      });
  }

  initForm() {
    this.myForm = this.fb.group({
      cantidad: [null, [Validators.required, Validators.max(this.maxCantidad)]],
      fecha: [new Date(), Validators.required],
      puntoVentaId: [null, Validators.required],
      updateState: [false],
    });
  }
}
