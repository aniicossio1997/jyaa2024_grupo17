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

  constructor(
    private fb: FormBuilder, private router: Router,
    private activatedRoute:ActivatedRoute,
    private ingresoMateriaPrimasService: IngresoMateriaPrimasService,
    private materiaPrimaService: MateriaPrimaService,
    private familiaProductoraService: FamiliaProductoraService
  ){
    /**
     {
  "descripcion": "string",
  "cantidad": 4,
  "codigo": "string",
  "valorCompra": 15,
  "materiaPrimaId": 1,
  "familiaPrimaId": 2,
  "estado": "ESTANTE"
}
     */
    this.initForm()
  }

  ngOnInit(): void {
    const id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
    this.materiaPrimaService.getById(id).subscribe(data=>{
      this.materiaPrima=data;
      this.myForm.updateValueAndValidity();
    });
    this.familiaProductoraService.get().subscribe(data=>{
      this.familias=data
    });

  }

  cancel(){
    //this.router.navigate(['/' + ManagementRoutes.MateriaPrima]);

  }
  save(){
   /* if (this.myForm.valid) {

      const entityToAdd:MateriaPrimaCreateViewModel= {
            nombre:this.myForm.get("nombre").value,
            descripcion:this.myForm.get("descripcion").value,
            unidadMedida: this.myForm.get(formKeysEnum.unidadMedida).value
      }

      this.materiaPrimaService.post(entityToAdd).subscribe(
        result => {
          if (result) {

            this.cancel()
          }
        }
      );

    }
      */

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
      materiaPrimaId:['', Validators.required],
      familiaPrimaId:['',Validators.required],
      estado:['', Validators.required]
    });
  }


}
