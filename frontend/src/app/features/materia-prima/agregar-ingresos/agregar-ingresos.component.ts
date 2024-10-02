import { Component, OnInit } from '@angular/core';
import { MateriaPrimaCreateViewModel } from '../../../interfaces/MateriaPrimaCreateViewModel';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { MenuItem } from 'primeng/api';
import { MateriaPrimaViewModel } from '../../../interfaces/MateriaPrimaViewModel';
import { ActivatedRoute, Router } from '@angular/router';
import { IngresoMateriaPrimasService } from '../../../services/ingreso-materia-primas.service';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { FamiliaProductoraService } from '../../familia-productora/familia-productora.service';
import { FamiliaProductoraViewModel } from '../../../interfaces/FamiliaProductoraViewModel';
import { UnidadMedidaEnum } from '../../../interfaces/UnidadMedidaEnum';
import { EstadoIngresoEnums } from '../../../model/EstadoIngresoEnums';
import { ManagementRoutes } from '../../../routers';
import { IngresoMateriaPrimaCreateViewModel } from '../../../interfaces/ingresoMateriaPrimaCreate';

@Component({
  selector: 'app-agregar-ingresos',
  templateUrl: './agregar-ingresos.component.html',
  styleUrl: './agregar-ingresos.component.scss',
  providers:[
    IngresoMateriaPrimasService,
    MateriaPrimaService,
    FamiliaProductoraService
  ]
})
export class AgregarIngresosComponent implements OnInit {

  myForm: FormGroup;

  estados: string[] = Object.keys(EstadoIngresoEnums);
  itemsMenu: MenuItem[] = [];

  materiaPrima:MateriaPrimaViewModel;

  familias:FamiliaProductoraViewModel[]=[]

  currentDate = new Date();

  constructor(
    private fb: FormBuilder, private router: Router,
    private activatedRoute:ActivatedRoute,
    private ingresoMateriaPrimasService: IngresoMateriaPrimasService,
    private materiaPrimaService: MateriaPrimaService,
    private familiaProductoraService: FamiliaProductoraService
  ){
    this.initForm()
  }

  ngOnInit(): void {
    const id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
    this.materiaPrimaService.getById(id).subscribe(data=>{
      this.materiaPrima=data;
      this.myForm.get("materiaPrimaId").setValue(this.materiaPrima.id)
      this.myForm.updateValueAndValidity();
    });
    this.familiaProductoraService.get().subscribe(data=>{
      this.familias=data
    });

    this.myForm.get("fecha").valueChanges.subscribe(data=>{
      console.log("FECHA", data)
    })

  }

  cancel(){
    this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Gestion}`,this.materiaPrima.id!]);
  }

  save(){
   if (this.myForm.valid) {

      const entityToAdd:IngresoMateriaPrimaCreateViewModel= {
            descripcion:this.myForm.get("descripcion").value,
            cantidad: this.myForm.get("cantidad").value,
            codigo:this.myForm.get("codigo").value,
            estado:this.myForm.get("estado").value,
            familiaPrimaId:this.myForm.get("familiaPrimaId").value,
            materiaPrimaId: this.myForm.get("materiaPrimaId").value,
            valorCompra: this.myForm.get("valorCompra").value,
            fecha:this.myForm.get("fecha").value

      }


      this.ingresoMateriaPrimasService.post(entityToAdd).subscribe(
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
      materiaPrimaId:['', Validators.required],
      familiaPrimaId:['',Validators.required],
      estado:['', Validators.required],
      fecha:[new Date(), Validators.required]
    });
  }

}
