import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ManagementRoutes } from '../../../routers';
import { PuntoVentaService } from '../punto-venta.service';
import PuntoVentaCreateViewModel from '../../../interfaces/PuntoVentaCreateViewModel';

@Component({
  selector: 'app-edit-puntoventa',
  templateUrl: './edit.component.html',
  providers: [PuntoVentaService],
})
export class EditComponent implements OnInit {
  public id!: number;
  myForm: FormGroup;
  constructor(
    private activateRouter: ActivatedRoute,
    private puntoVentaService: PuntoVentaService,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.myForm = this.fb.group({
      nombre: ['', Validators.required],
      descripcion: [''],
    });
  }

  ngOnInit(): void {
    // Obtener el parámetro :id utilizando snapshot
    this.id = Number(this.activateRouter.snapshot.paramMap.get('id')!);

    if (this.id) {
      this.puntoVentaService.getById(this.id!).subscribe((data) => {
        this.myForm.get('nombre').setValue(data.nombre),
          this.myForm.get('descripcion').setValue(data.descripcion);
        // Marcar controles como tocados para forzar la actualización de validaciones
        this.myForm.get('nombre').markAsTouched();
        this.myForm.get('descripcion').markAsTouched();

        this.myForm.updateValueAndValidity(); // Actualiza las validaciones sincrónicas
      });
    }
  }

  cancel() {
    this.router.navigate(['/' + ManagementRoutes.PuntoVenta]);
  }
  save() {
    if (this.myForm.valid) {
      const entityToAdd: PuntoVentaCreateViewModel = {
        nombre: this.myForm.get('nombre').value,
        descripcion: this.myForm.get('descripcion').value,
      };

      this.puntoVentaService
        .update(this.id, entityToAdd)
        .subscribe((result) => {
          if (result) {
            this.cancel();
          }
        });
    }
  }

  get formNombre() {
    return this.myForm.get('nombre').valueChanges.pipe();
  }
}
