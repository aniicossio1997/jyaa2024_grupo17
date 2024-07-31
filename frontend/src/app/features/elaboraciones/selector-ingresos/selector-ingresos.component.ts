import { filter } from 'rxjs';
import { Component, ViewChild } from '@angular/core';
import { IngresoMateriaPrimaShortViewModel } from '../../../interfaces/ingresoMateriaPrimaShortViewModel';
import {
  DialogService,
  DynamicDialogConfig,
  DynamicDialogRef,
} from 'primeng/dynamicdialog';
import { EstadoIngresoEnums } from '../../../model/EstadoIngresoEnums';
import {
  AbstractControl,
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { EstadoIngresoMateriaPrimaService } from '../../../services/estado-ingreso-materia-prima.service';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { MateriaPrimaDetailViewModel } from '../../../interfaces/MateriaPrimaDetailViewModel';
import { Dropdown, DropdownChangeEvent } from 'primeng/dropdown';

function greaterThanZero(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  return value > 0 ? null : { greaterThanZero: true };
}

@Component({
  selector: 'app-ingreso-cambiar-estado',
  templateUrl: './selector-ingresos.component.html',
  providers: [DialogService, MateriaPrimaService],
})
export class SelectorIngresosComponent {
  myForm: FormGroup;
  materiaPrimaId: number;
  cantidadRequerida: number;
  materiaPrima: MateriaPrimaDetailViewModel;
  callback: (materiaPrimaId: number, data: {ingresoMateriaPrimaId: number, cantidad: number}[]) => void;
  msjError: string = undefined;
  selectedIngresos: IngresoMateriaPrimaShortViewModel[] = [];
  submited: boolean = false;


  @ViewChild('ingresosDropdown') ingresosDropdown: Dropdown;

  constructor(
    private ref: DynamicDialogRef,
    private fb: FormBuilder,
    private config: DynamicDialogConfig,
    private materiaPrimaService: MateriaPrimaService
  ) {
    this.initForm();
  }

  ngOnInit() {
    this.materiaPrimaId = this.config.data.materiaPrima.id;
    this.cantidadRequerida = this.config.data.cantidadRequerida;
    const initialData: { ingresoMateriaPrimaId: number; cantidad: number; }[] = this.config.data.initialData ?? [];
    this.callback = this.config.data.callback;
    if (this.materiaPrimaId) {
      this.materiaPrimaService.getById(this.materiaPrimaId).subscribe((r) => {
        this.materiaPrima = r;

        initialData.forEach(initial => {
          const found = this.materiaPrima.ingresos.find(i => i.id == initial.ingresoMateriaPrimaId);
          if (found) {
            this.selectedIngresos.push(found);
            this.getIngresosFormArr().push(new FormControl(initial.cantidad, greaterThanZero));
          }
        })
      });
    }
  }

  onSelectIngreso(event: DropdownChangeEvent) {
    const ingreso = event.value;
    if (!ingreso) return;
    if (!this.selectedIngresos.find((i) => i.id == ingreso.id)) {
      this.selectedIngresos.push(ingreso);
      this.getIngresosFormArr().push(new FormControl(0, greaterThanZero));
    }
    this.ingresosDropdown.clear();
  }

  onDeleteIngreso(id: Number) {
    const index = this.selectedIngresos.findIndex((i) => i.id == id);
    if (index > -1) {
      this.selectedIngresos.splice(index, 1);
      this.getIngresosFormArr().removeAt(index);
    }
  }

  getIngresosFormArr() {
    return this.myForm.get('cantidades') as FormArray;
  }

  getMin(a: number, b: number): number {
    return Math.min(a, b);
  }

  cancel() {
    this.ref.close();
  }
  save() {
    const cantidades = this.getIngresosFormArr().getRawValue();
    const data = this.selectedIngresos.map((ingreso, index) => ({
      ingresoMateriaPrimaId: ingreso.id,
      cantidad: cantidades[index],
    }));
    this.submited = true;
    if (this.getErrorMessage()) {
      return;
    }
    console.log({materiaPrimaId: this.materiaPrimaId, data: data});
    this.callback(this.materiaPrimaId, data);
    this.ref.close();
  }

  get cantidadTotalSeleccionada() {
    const values = this.getIngresosFormArr().getRawValue();
    return values
      .reduce((total, seleccionado) => total + seleccionado, 0);
  }

  getErrorMessage(){
    if (!this.submited) return null;
    if (this.cantidadTotalSeleccionada > this.cantidadRequerida) {
      return "La cantidad seleccionada supera la cantidad requerida, por favor ajusta las cantidades."
    }
    if (this.cantidadTotalSeleccionada < this.cantidadRequerida) {
      return "La cantidad seleccionada no cubre la cantidad requerida, por favor ajusta las cantidades."
    }
    return null;
  }

  getSeverity(estado: EstadoIngresoEnums) {
    switch (estado) {
      case EstadoIngresoEnums.CAMARA_FRIO:
        return 'primary';
      case EstadoIngresoEnums.ESTANTE:
        return 'warning';
      case EstadoIngresoEnums.FREEZER:
        return 'info';
    }
  }

  initForm() {
    this.myForm = this.fb.group({
      cantidades: new FormArray([], Validators.required),
    });
  }
}
