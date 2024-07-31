import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { IngresoMateriaPrimasService } from '../../../../services/ingreso-materia-primas.service';
import { IngresoMateriaPrimaDetailViewModel } from '../../../../interfaces/IngresoMateriaPrimaDetailViewModel';
import { UnidadMedidaEnum } from '../../../../interfaces/UnidadMedidaEnum';
import { IngresoMateriaPrimaCreateViewModel } from '../../../../interfaces/ingresoMateriaPrimaCreate';
import { ManagementRoutes } from '../../../../routers';
import { FamiliaProductoraViewModel } from '../../../../interfaces/FamiliaProductoraViewModel';
import { FamiliaProductoraService } from '../../../familia-productora/familia-productora.service';
import { EstadoIngresoEnums } from '../../../../model/EstadoIngresoEnums';

@Component({
  selector: 'app-ingreso-edit',
  templateUrl: './ingreso-edit.component.html',
  styleUrl: './ingreso-edit.component.scss',
  providers:[IngresoMateriaPrimasService,
    FamiliaProductoraService
  ]

})
export class IngresoEditComponent implements OnInit {
  myForm: FormGroup;
  id:number;
  ingreso!: IngresoMateriaPrimaDetailViewModel;
  unidadMedidaArray: string[] = Object.keys(UnidadMedidaEnum);
  estados: string[] = Object.keys(EstadoIngresoEnums);
  familias:FamiliaProductoraViewModel[]=[]


  constructor(private activatedRoute:ActivatedRoute,
    private router:Router, private ingresoMateriaPrimasService: IngresoMateriaPrimasService,
    private fb: FormBuilder, private familiaProductoraService: FamiliaProductoraService
  ){
    this.initForm()
  }

  ngOnInit(): void {
    this.getRefresh();
    this.familiaProductoraService.get().subscribe(data=>{
      this.familias=data
    });
  }

  getRefresh(){
    this.id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
    this.ingresoMateriaPrimasService.getById(this.id).subscribe(data=>{
      this.ingreso=data!;
          if(this.ingreso){
      this.myForm.get("descripcion").setValue(this.ingreso.descripcion);
      this.myForm.get("valorCompra").setValue(this.ingreso.valorCompra);
      this.myForm.get("cantidad").setValue(this.ingreso.cantidad);
      this.myForm.get("materiaPrimaId").setValue(this.ingreso.materiaPrima.id);
      this.myForm.get("familiaPrimaId").setValue(this.ingreso.familiaProductora.id!);
      this.myForm.get("estado").setValue(this.ingreso.currentState.nombre);
      this.myForm.get("fecha").setValue(new Date(this.ingreso.fecha));

      // Marcar controles como tocados para forzar la actualización de validaciones


      this.myForm.updateValueAndValidity(); // Actualiza las validaciones sincrónicas

    }
    })

  }

  initForm(){
    this.myForm = this.fb.group({
      descripcion: [''],
      valorCompra: ['', [Validators.required, this.positiveNumberValidator]],
      cantidad: ['', [Validators.required, this.positiveNumberValidator]],
      materiaPrimaId:['', Validators.required],
      familiaPrimaId:['',Validators.required],
      estado:['', Validators.required],
      fecha:['', Validators.required]
    });
  }

  positiveNumberValidator: ValidatorFn = (control: AbstractControl): { [key: string]: any } | null => {
    const value = control.value;
    if (isNaN(value) || value < 0) {
      return { 'positiveNumber': { value: control.value } };
    }
    return null;
  };

  cancel(){
    this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Gestion}`,this.ingreso.materiaPrima.id!]);
  }

  save(){
   if (this.myForm.valid) {

      const entityToAdd:IngresoMateriaPrimaCreateViewModel= {
            descripcion:this.myForm.get("descripcion").value,
            cantidad: this.myForm.get("cantidad").value,
            codigo:this.ingreso.codigo,
            estado:this.myForm.get("estado").value,
            familiaPrimaId:this.myForm.get("familiaPrimaId").value,
            materiaPrimaId: this.ingreso.materiaPrima.id,
            valorCompra: this.myForm.get("valorCompra").value
      }

      this.ingresoMateriaPrimasService.put(this.ingreso.id,entityToAdd).subscribe(
        result => {
          if (result) {
            this.back()
          }
        }
      );

    }
  }
  back(){
    this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Gestion}/`, this.ingreso.materiaPrima.id!]); // Usa item.id para redirigir

  }
  get currentDate(){
    return new Date();
  }
}
