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
import RecetaViewModel from '../../../interfaces/RecetaViewModel';
import { RecetasService } from '../../../services/recetas.service';
import { Router } from '@angular/router';
import { ManagementRoutes } from '../../../routers';

function greaterThanZero(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  return value > 0 ? null : { greaterThanZero: true };
}

@Component({
  selector: 'app-ingreso-cambiar-estado',
  templateUrl: './selector-recetas.component.html',
  providers: [DialogService, RecetasService],
})
export class SelectorRecetaComponent {
  recetas: RecetaViewModel[] = [];
  recetaId: number;

  constructor(
    private ref: DynamicDialogRef,
    private recetaService: RecetasService,
    public router: Router
  ) {}

  ngOnInit() {
    this.recetaService.get().subscribe((r) => {
      this.recetas = r;
    });
  }

  onSelectReceta(event: DropdownChangeEvent) {
    this.recetaId = event.value.id;
  }

  cancel() {
    this.ref.close();
  }
  save() {
    if (!this.recetaId) return;
    this.router.navigate([
      `/${ManagementRoutes.Elaboracion}/${ManagementRoutes.New}/`,
      this.recetaId,
    ]);
    this.ref.close();
  }
}
