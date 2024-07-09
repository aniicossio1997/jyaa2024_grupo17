import { RecetasService } from '../../../services/recetas.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import {
  AbstractControl,
  FormArray,
  FormControl,
  FormGroup,
  ValidationErrors,
} from '@angular/forms';
import { SelectItem } from 'primeng/api';
import { Validators } from '@angular/forms';
import { Password } from 'primeng/password';
import { ActivatedRoute, Router } from '@angular/router';
import { ManagementRoutes } from '../../../routers';
import { ToastrService } from 'ngx-toastr';
import { RecetaDetalleViewModel } from '../../../interfaces/RecetaDetalleViewModel';
import RecetaCreateViewModel from '../../../interfaces/RecetaCreateViewModel';
import { MateriaPrimaViewModel } from '../../../interfaces/MateriaPrimaViewModel';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { Dropdown, DropdownChangeEvent } from 'primeng/dropdown';
import InsumoViewModel from '../../../interfaces/InsumoViewModel';
import { InsumosService } from '../../../services/insumo.service';

interface IngredienteCreateViewModel {
  insumoId?: number;
  materiaPrimaId?: number;
  id?: number;
  nombre: string;
  unidadMedida: string;
  cantidad?: number;
}

function greaterThanZero(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  return value > 0 ? null : { greaterThanZero: true };
}

@Component({
  providers: [RecetasService, MateriaPrimaService, InsumosService],
  selector: 'receta-edit',
  templateUrl: './edit.component.html',
})
export class EditComponent implements OnInit {
  receta: RecetaDetalleViewModel;
  loading = false;
  id: number;
  allMateriasPrimas: MateriaPrimaViewModel[] = [];
  allInsumos: InsumoViewModel[] = [];

  selectedMateriasPrimas: IngredienteCreateViewModel[] = [];
  selectedInsumos: IngredienteCreateViewModel[] = [];

  @ViewChild('materiaPrimaDropdown') materiaPrimaDropdown: Dropdown;
  @ViewChild('insumosDropdown') insumosDropdown: Dropdown;
  form: FormGroup;

  constructor(
    private recetasService: RecetasService,
    private materiaPrimaService: MateriaPrimaService,
    private insumosService: InsumosService,
    private router: Router,
    private toastr: ToastrService,
    private activatedRoute: ActivatedRoute
  ) {
    this.id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
  }

  ngOnInit() {
    this.recetasService.detail(this.id).subscribe((res) => {
      this.receta = res;
      this.selectedInsumos = res.ingredientes
        .filter((i) => i.insumo != null)
        .map((i) => ({
          id: i.id,
          nombre: i.insumo.nombre,
          insumoId: i.insumo.id,
          unidadMedida: i.insumo.unidadMedida,
          cantidad: i.cantidad,
        }));

      this.selectedMateriasPrimas = res.ingredientes
        .filter((i) => i.materiaPrima != null)
        .map((i) => ({
          id: i.id,
          nombre: i.materiaPrima.nombre,
          materiaPrimaId: i.materiaPrima.id,
          unidadMedida: i.materiaPrima.unidadMedida,
          cantidad: i.cantidad,
        }));
      this.form = new FormGroup({
        nombre: new FormControl(res.nombre, Validators.required),
        descripcion: new FormControl(
          res.descripcion,
          Validators.maxLength(256)
        ),
        insumos: new FormArray(
          this.selectedInsumos.map(
            (i) => new FormControl(i.cantidad, greaterThanZero)
          ),
          Validators.required
        ),
        materiasPrimas: new FormArray(
          this.selectedMateriasPrimas.map(
            (i) => new FormControl(i.cantidad, greaterThanZero)
          ),
          Validators.required
        ),
      });
    });
    this.materiaPrimaService
      .get()
      .subscribe((res) => (this.allMateriasPrimas = res));

    this.insumosService.get().subscribe((res) => (this.allInsumos = res));
  }

  onSubmit() {
    if (!this.form.valid) return;
    const raw = this.form.getRawValue();
    const insumos = this.selectedInsumos.map((i, index) => ({
      insumoId: i.insumoId,
      materiaPrimaId: null,
      cantidad: raw.insumos[index],
    }));

    const materiasPrimas = this.selectedMateriasPrimas.map((i, index) => ({
      materiaPrimaId: i.materiaPrimaId,
      insumoId: null,
      cantidad: raw.materiasPrimas[index],
    }));

    const ingredientes = [...insumos, ...materiasPrimas];

    const request: RecetaCreateViewModel = {
      nombre: raw.nombre,
      descripcion: raw.descripcion,
      ingredientes: ingredientes,
    };

    this.loading = true;
    this.recetasService.edit(this.id, request).subscribe((res) => {
      this.toastr.success('Se han guardado los cambios');
      this.router.navigate([
        '/' + ManagementRoutes.Receta,
        ManagementRoutes.Detail,
        this.receta.id,
      ]);
    });
  }

  get filteredInsumos() {
    const selectedIds = this.selectedInsumos.map((insumo) => insumo.insumoId);
    return this.allInsumos.filter((insumo) => !selectedIds.includes(insumo.id));
  }

  get filteredMateriasPrimas() {
    const selectedIds = this.selectedMateriasPrimas.map(
      (mp) => mp.materiaPrimaId
    );
    return this.allMateriasPrimas.filter((mp) => !selectedIds.includes(mp.id));
  }

  getMateriasPrimasFormArr() {
    return this.form.get('materiasPrimas') as FormArray;
  }

  onSelectMateriaPrima(event: DropdownChangeEvent) {
    const materiaPrima = event.value;
    if (!materiaPrima) return;
    if (
      !this.selectedMateriasPrimas.find(
        (i) => i.id == materiaPrima.materiaPrimaId
      )
    ) {
      this.selectedMateriasPrimas.push({
        id: materiaPrima.id,
        materiaPrimaId: materiaPrima.id,
        nombre: materiaPrima.nombre,
        cantidad: 0,
        unidadMedida: materiaPrima.unidadMedida,
      });
      this.getMateriasPrimasFormArr().push(
        new FormControl('', greaterThanZero)
      );
    }
    this.materiaPrimaDropdown.clear();
  }

  onDeleteMateriaPrima(id: Number) {
    const index = this.selectedMateriasPrimas.findIndex(
      (i) => i.materiaPrimaId == id
    );
    if (index > -1) {
      this.selectedMateriasPrimas.splice(index, 1);
      this.getMateriasPrimasFormArr().removeAt(index);
    }
  }

  getInsumosArr() {
    return this.form.get('insumos') as FormArray;
  }

  onSelectInsumo(event: DropdownChangeEvent) {
    const insumo = event.value;
    if (!insumo) return;
    if (!this.selectedInsumos.find((i) => i.insumoId == insumo.id)) {
      this.selectedInsumos.push({
        insumoId: insumo.id,
        nombre: insumo.nombre,
        cantidad: 0,
        unidadMedida: insumo.unidadMedida,
      });
      this.getInsumosArr().push(new FormControl('', greaterThanZero));
    }
    this.insumosDropdown.clear();
  }

  onDeleteInsumo(id: Number) {
    const index = this.selectedInsumos.findIndex((i) => i.insumoId == id);
    if (index > -1) {
      this.selectedInsumos.splice(index, 1);
      this.getInsumosArr().removeAt(index);
    }
  }

  cancel() {
    this.router.navigate([
      '/' + ManagementRoutes.Receta,
      ManagementRoutes.Query,
    ]);
  }
}
