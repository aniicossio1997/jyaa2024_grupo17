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
import { Router } from '@angular/router';
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
  cantidad: number;
  nombre: string;
  unidadMedida: string;
}

function greaterThanZero(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  return value > 0 ? null : { greaterThanZero: true };
}

@Component({
  providers: [RecetasService, MateriaPrimaService, InsumosService],
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css'],
})
export class NewComponent implements OnInit {
  loading = false;

  allMateriasPrimas: MateriaPrimaViewModel[] = [];
  allInsumos: InsumoViewModel[] = [];

  selectedMateriasPrimas: IngredienteCreateViewModel[] = [];
  selectedInsumos: IngredienteCreateViewModel[] = [];

  @ViewChild('materiaPrimaDropdown') materiaPrimaDropdown: Dropdown;
  @ViewChild('insumosDropdown') insumosDropdown: Dropdown;

  form = new FormGroup({
    nombre: new FormControl('', [
      Validators.required,
      Validators.maxLength(256),
    ]),
    descripcion: new FormControl('', Validators.maxLength(256)),
    materiasPrimas: new FormArray([], Validators.required),
    insumos: new FormArray([], Validators.required),
  });

  constructor(
    private recetasService: RecetasService,
    private materiaPrimaService: MateriaPrimaService,
    private insumosService: InsumosService,

    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit() {
    this.materiaPrimaService
      .get()
      .subscribe((res) => (this.allMateriasPrimas = res));

    this.insumosService.get().subscribe((res) => (this.allInsumos = res));
  }

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.form.value);
    if (!this.form.valid) return;
    const raw = this.form.getRawValue();

    const insumos = this.selectedInsumos.map((i, index) => ({
      insumoId: i.id,
      materiaPrimaId: null,
      cantidad: raw.insumos[index],
    }));

    const materiasPrimas = this.selectedMateriasPrimas.map((i, index) => ({
      materiaPrimaId: i.id,
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
    this.recetasService.create(request).subscribe((res) => {
      this.toastr.success('Se ha agregado la receta');
      this.router.navigate([
        '/' + ManagementRoutes.Receta,
        ManagementRoutes.Query,
      ]);
    });
  }

  get filteredInsumos() {
    const selectedIds = this.selectedInsumos.map((insumo) => insumo.id);
    return this.allInsumos.filter((insumo) => !selectedIds.includes(insumo.id));
  }

  get filteredMateriasPrimas() {
    const selectedIds = this.selectedMateriasPrimas.map((mp) => mp.id);
    return this.allMateriasPrimas.filter((mp) => !selectedIds.includes(mp.id));
  }

  getMateriasPrimasFormArr() {
    return this.form.get('materiasPrimas') as FormArray;
  }

  onSelectMateriaPrima(event: DropdownChangeEvent) {
    const materiaPrima = event.value;
    if (!materiaPrima) return;
    if (!this.selectedMateriasPrimas.find((i) => i.id == materiaPrima.id)) {
      this.selectedMateriasPrimas.push({
        id: materiaPrima.id,
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
    const index = this.selectedMateriasPrimas.findIndex((i) => i.id == id);
    if (index > -1) {
      this.selectedMateriasPrimas.splice(index, 1);
      this.getMateriasPrimasFormArr().removeAt(index);
    }
  }

  getInsumosArr() {
    return this.form.get('insumos') as FormArray;
  }

  onSelectInsumo(event: DropdownChangeEvent) {
    const insumos = event.value;
    if (!insumos) return;
    if (!this.selectedInsumos.find((i) => i.id == insumos.id)) {
      this.selectedInsumos.push({
        id: insumos.id,
        nombre: insumos.nombre,
        cantidad: 0,
        unidadMedida: insumos.unidadMedida,
      });
      this.getInsumosArr().push(new FormControl('', greaterThanZero));
    }
    this.insumosDropdown.clear();
  }

  onDeleteInsumo(id: Number) {
    const index = this.selectedInsumos.findIndex((i) => i.id == id);
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
