import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { ManagementRoutes } from '../../../../routers';
import { InsumoDetailViewModel } from '../../../../interfaces/InsumoDetailViewModel';
import { IngresoInsumoViewModel } from '../../../../interfaces/IngresoInsumoViewModel';
import { ActivatedRoute, Router } from '@angular/router';
import { IngresoInsumoService } from '../../../../services/ingreso-insumo.service';
import { InsumosService } from '../../../../services/insumo.service';
import { IngresoInsumoCreateViewModel } from '../../../../interfaces/IngresoInsumoCreateViewModel';

@Component({
  selector: 'app-insumos-edit-ingreso',
  templateUrl: './insumos-edit-ingreso.component.html',
  styleUrl: './insumos-edit-ingreso.component.scss',
  providers:[IngresoInsumoService,InsumosService]
})
export class InsumosEditIngresoComponent {
  myForm: FormGroup;
  ingreso:IngresoInsumoViewModel

  id:number;
  constructor(private activatedRoute:ActivatedRoute,
    private router:Router,
    private ingresoInsumoService: IngresoInsumoService,
    private fb: FormBuilder,
    private insumosService:InsumosService
  ){
    this.initForm()
  }

  ngOnInit(): void {
    this.id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
    this.ingresoInsumoService.getById(this.id).subscribe(data=>{
      if(data){
        this.ingreso=data;
        this.myForm.get("descripcion").setValue(this.ingreso.descripcion);
        this.myForm.get("valorCompra").setValue(this.ingreso.valorCompra);
        this.myForm.get("cantidad").setValue(this.ingreso.cantidad);
        this.myForm.updateValueAndValidity();
      }
    });

  }



  cancel(){
    this.router.navigate([`/${ManagementRoutes.Insumo}/${ManagementRoutes.Gestion}`,this.ingreso.insumo.id!]);
  }

  save(){
   if (this.myForm.valid) {

      const entityToAdd:IngresoInsumoCreateViewModel= {
            descripcion:this.myForm.get("descripcion").value,
            cantidad: this.myForm.get("cantidad").value,
            codigo:this.ingreso.codigo,
            valorCompra: this.myForm.get("valorCompra").value,
            insumoId:this.ingreso.insumo.id!
      }

      this.ingresoInsumoService.putEdit(this.id,entityToAdd).subscribe(
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
      valorCompra: ['', [Validators.required, this.positiveNumberValidator]],
      codigo:[''],
      cantidad: ['', [Validators.required, this.positiveNumberValidator]],
    });
  }
}
