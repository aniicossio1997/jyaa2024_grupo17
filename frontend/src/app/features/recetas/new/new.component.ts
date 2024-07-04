import { RecetasService } from './../recetas.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
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

@Component({
  providers: [RecetasService, MateriaPrimaService],
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css'],
})
export class NewComponent implements OnInit {
  loading = false;

  allMateriasPrimas: MateriaPrimaViewModel[] = [];

  selectedMateriasPrimas: MateriaPrimaViewModel[] = [];

  @ViewChild('ingDropdown') ingDropdown: Dropdown;

  form = new FormGroup({
    nombre: new FormControl('', Validators.required),
    descripcion: new FormControl('', Validators.required),
  });

  constructor(
    private recetasService: RecetasService,
    private materiaPrimaService: MateriaPrimaService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit() {
    this.materiaPrimaService
      .get()
      .subscribe((res) => (this.allMateriasPrimas = res));
  }

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.form.value);
    const raw = this.form.getRawValue();
    const request: RecetaCreateViewModel = {
      nombre: raw.nombre,
      descripcion: raw.descripcion,
      ingredientes: [],
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

  onSelectMateriaPrima(event: DropdownChangeEvent) {
    const materiaPrima = event.value;
    if (!this.selectedMateriasPrimas.find((i) => i.id == materiaPrima.id)) {
      this.selectedMateriasPrimas.push(materiaPrima);
    }
    this.ingDropdown.clear();
  }

  onDeleteIngrediente(id: Number) {
    const index = this.selectedMateriasPrimas.findIndex((i) => i.id == id);
    if (index > -1) {
      this.selectedMateriasPrimas.splice(index, 1);
    }
  }
  back() {
    this.router.navigate([
      '/' + ManagementRoutes.Receta,
      ManagementRoutes.Query,
    ]);
  }
}
