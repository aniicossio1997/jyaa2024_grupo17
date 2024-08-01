import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ManagementRoutes } from '../../../routers';
import { PuntoVentaService } from '../punto-venta.service';
import PuntoVentaCreateViewModel from '../../../interfaces/PuntoVentaCreateViewModel';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  providers: [PuntoVentaService],
})
export class NewComponent implements OnInit {
  myForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private puntoVentaService: PuntoVentaService,
    private toastr: ToastrService
  ) {
    this.myForm = this.fb.group({
      nombre: ['', Validators.required],
      descripcion: [''],
    });
  }

  ngOnInit() {}

  cancel() {
    this.router.navigate(['/' + ManagementRoutes.PuntoVenta]);
  }
  save() {
    if (this.myForm.valid) {
      const entityToAdd: PuntoVentaCreateViewModel = {
        nombre: this.myForm.get('nombre').value,
        descripcion: this.myForm.get('descripcion').value,
      };

      this.puntoVentaService.post(entityToAdd).subscribe((result) => {
        if (result) {
          this.cancel();
        }
      });
    }
  }
}
