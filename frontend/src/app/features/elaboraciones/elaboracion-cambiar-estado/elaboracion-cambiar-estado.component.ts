import { EstadoElaboracionService } from './../../../services/estado-elaboracion.service';
import { Component } from '@angular/core';
import {
  DialogService,
  DynamicDialogConfig,
  DynamicDialogRef,
} from 'primeng/dynamicdialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EstadoElaboracionEnum } from '../../../model/EstadoElaboracionEnum';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-elaboracion-cambiar-estado',
  templateUrl: './elaboracion-cambiar-estado.component.html',
  providers: [DialogService, EstadoElaboracionService],
})
export class ElaboracionCambiarEstadoComponent {
  elaboracionId: number;
  estadoInicial: EstadoElaboracionEnum;
  estados: string[] = Object.keys(EstadoElaboracionEnum);
  myForm: FormGroup;
  callback: () => void;
  msjError: string = undefined;
  currentDate = new Date();
  loading = false;

  constructor(
    private dialogService: DialogService,
    private ref: DynamicDialogRef,
    private fb: FormBuilder,
    private config: DynamicDialogConfig,
    private toastr: ToastrService,
    private estadoElaboracionService: EstadoElaboracionService
  ) {
    this.initForm();
  }

  ngOnInit() {
    this.elaboracionId = this.config.data.elaboracionId;
    this.estadoInicial = this.config.data.estadoInicial;
    this.callback = this.config.data.callback;
    this.myForm.get('estado').setValue(this.estadoInicial);

    this.myForm.get('estado').valueChanges.subscribe((data) => {
      if (data != this.msjError) this.msjError = undefined;
    });
  }

  cancel() {
    this.ref.close();
  }
  save() {
    if (this.myForm.get('estado').value == this.estadoInicial) {
      this.msjError = 'Debes asignar un estado distinto al actual';
      return;
    }
    this.msjError = undefined;
    this.loading = true;
    this.estadoElaboracionService
      .create({
        estado: this.myForm.get('estado').value,
        elaboracionId: this.elaboracionId,
        fecha: this.myForm.get('fecha').value,
      })
      .subscribe((data) => {
        this.loading = false;
        this.toastr.success('Se ha actualizado el estado de la elaboración!');
        this.cancel();
        this.callback();
      });
  }

  initForm() {
    this.myForm = this.fb.group({
      estado: ['', Validators.required],
      fecha: [new Date(), Validators.required],
    });
  }
}
