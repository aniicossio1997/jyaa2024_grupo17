import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IngresoInsumoService } from '../../../../services/ingreso-insumo.service';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { IngresoInsumoViewModel } from '../../../../interfaces/IngresoInsumoViewModel';
import { IngresoInsumoCreateViewModel } from '../../../../interfaces/IngresoInsumoCreateViewModel';
import { ManagementRoutes } from '../../../../routers';
import InsumoViewModel from '../../../../interfaces/InsumoViewModel';
import { InsumosService } from '../../../../services/insumo.service';
import { InsumoDetailViewModel } from '../../../../interfaces/InsumoDetailViewModel';

@Component({
  selector: 'app-insumo-add-ingreso',
  templateUrl: './insumo-add-ingreso.component.html',
  styleUrl: './insumo-add-ingreso.component.scss',
  providers:[IngresoInsumoService, InsumosService]
})
export class InsumoAddIngresoComponent implements OnInit {
  myForm: FormGroup;
  insumo:InsumoDetailViewModel

  constructor(private activatedRoute:ActivatedRoute,
    private router:Router,
    private ingresoInsumoService: IngresoInsumoService,
    private fb: FormBuilder,
    private insumosService:InsumosService
  ){
    this.initForm()
  }

  ngOnInit(): void {
      const id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
    this.insumosService.getById(id).subscribe(data=>{
      this.insumo=data;
      /*
            descripcion: [''],
      valorCompra: ['', [Validators.required, this.positiveNumberValidator]],
      codigo:[''],
      cantidad: ['', [Validators.required, this.positiveNumberValidator]],
      */
      //this.myForm.get("materiaPrimaId").setValue(this.materiaPrima.id)
      this.myForm.updateValueAndValidity();
    });

  }



  cancel(){
    this.router.navigate([`/${ManagementRoutes.Insumo}/${ManagementRoutes.Gestion}`,this.insumo.id!]);
  }

  save(){
   if (this.myForm.valid) {

      const entityToAdd:IngresoInsumoCreateViewModel= {
            descripcion:this.myForm.get("descripcion").value,
            cantidad: this.myForm.get("cantidad").value,
            codigo:'',
            valorCompra: this.myForm.get("valorCompra").value,
            insumoId:this.insumo.id!
      }

      this.ingresoInsumoService.post(entityToAdd).subscribe(
        result => {
          if (result) {

            this.cancel()
          }
        }
      );

    }
  }

  positiveNumberValidator: ValidatorFn = (control: AbstractControl): { [key: string]: any } | null => {
    const value = control.value;
    if (isNaN(value) || value < 0) {
      return { 'positiveNumber': { value: control.value } };
    }
    return null;
  };


  initForm(){
    this.myForm = this.fb.group({
      descripcion: [''],
      valorCompra: [null, [Validators.required, this.positiveNumberValidator]],
      codigo:[''],
      cantidad: [null, [Validators.required, this.positiveNumberValidator]],
    });
  }
}
