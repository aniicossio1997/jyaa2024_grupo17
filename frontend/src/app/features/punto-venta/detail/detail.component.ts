import { EntregaElaboracionService } from './../../../services/entrega-elaboracion-service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ManagementRoutes } from '../../../routers';
import { PuntoVentaService } from '../punto-venta.service';
import PuntoVentaCreateViewModel from '../../../interfaces/PuntoVentaCreateViewModel';
import { PuntoVentaViewModel } from '../../../interfaces/PuntoVentaViewModel';
import { EntregaElaboracionViewModel } from '../../../interfaces/EntregaElaboracionViewModel';

@Component({
  selector: 'app-detail-puntoventa',
  templateUrl: './detail.component.html',
  providers: [PuntoVentaService, EntregaElaboracionService],
})
export class DetailComponent implements OnInit {
  public id!: number;
  puntoVenta: PuntoVentaViewModel;
  entregas: EntregaElaboracionViewModel[] = [];

  constructor(
    private activateRouter: ActivatedRoute,
    private puntoVentaService: PuntoVentaService,
    private entregaElaboracionService: EntregaElaboracionService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    // Obtener el parámetro :id utilizando snapshot
    this.id = Number(this.activateRouter.snapshot.paramMap.get('id')!);

    if (this.id) {
      this.puntoVentaService.getById(this.id!).subscribe((data) => {
        this.puntoVenta = data;
      });

      this.entregaElaboracionService.getAll({puntoVentaId:this.id}).subscribe((data) => {
        this.entregas = data;
      });
    }
  }

  public get Routes() {
    return {
      EDIT: `/${ManagementRoutes.PuntoVenta}/${ManagementRoutes.Edit}/${this.puntoVenta?.id}`,
    };
  }
  cancel() {
    this.router.navigate(['/' + ManagementRoutes.PuntoVenta]);
  }
 
}
