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
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { MateriaPrimaDetailViewModel } from '../../../interfaces/MateriaPrimaDetailViewModel';
import { Dropdown, DropdownChangeEvent } from 'primeng/dropdown';
import { NotaService } from '../../../services/nota.service';
import { ToastrService } from 'ngx-toastr';

function greaterThanZero(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  return value > 0 ? null : { greaterThanZero: true };
}

@Component({
  selector: 'app-ingreso-cambiar-nota',
  templateUrl: './nota-dialog.component.html',
  providers: [DialogService, NotaService],
})
export class NotaDialogComponent {
  myForm: FormGroup;
  materiaPrimaId: number;
  cantidadRequerida: number;
  materiaPrima: MateriaPrimaDetailViewModel;
  callback: () => void;
  msjError: string = undefined;
  selectedIngresos: IngresoMateriaPrimaShortViewModel[] = [];
  submited: boolean = false;
  elaboracionId: number;

  @ViewChild('ingresosDropdown') ingresosDropdown: Dropdown;

  constructor(
    private ref: DynamicDialogRef,
    private fb: FormBuilder,
    private toastr: ToastrService,
    private notaService: NotaService,
    private config: DynamicDialogConfig
  ) {
    this.initForm();
  }

  ngOnInit() {
    this.callback = this.config.data.callback;
    this.elaboracionId = this.config.data.elaboracionId;
  }

  cancel() {
    this.ref.close();
  }

  save() {
    const raw = this.myForm.getRawValue();
    const req = {
      descripcion: raw.descripcion,
      elaboracionId: this.elaboracionId,
    };
    this.notaService.create(req).subscribe(() => {
      this.toastr.success('Se ha añadido la nota!');
      this.callback();
      this.ref.close();
    });
  }

  initForm() {
    this.myForm = this.fb.group({
      descripcion: new FormControl('', [
        Validators.minLength(3),
        Validators.maxLength(256),
      ]),
    });
  }
}
