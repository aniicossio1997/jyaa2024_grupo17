import { Component } from '@angular/core';
import { IngresoMateriaPrimaShortViewModel } from '../../../../interfaces/ingresoMateriaPrimaShortViewModel';
import { DialogService, DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { EstadoIngresoEnums } from '../../../../model/EstadoIngresoEnums';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EstadoIngresoMateriaPrimaService } from '../../../../services/estado-ingreso-materia-prima.service';

@Component({
  selector: 'app-ingreso-cambiar-estado',
  templateUrl: './ingreso-cambiar-estado.component.html',
  styleUrl: './ingreso-cambiar-estado.component.scss',
  providers:[DialogService, EstadoIngresoMateriaPrimaService]
})
export class IngresoCambiarEstadoComponent {
  ingreso: IngresoMateriaPrimaShortViewModel;
  estados: string[] = Object.keys(EstadoIngresoEnums);
  myForm: FormGroup;
  callback: () => void
  msjError:string=undefined;

  constructor( private dialogService: DialogService, private ref: DynamicDialogRef,
    private fb: FormBuilder,  private config: DynamicDialogConfig,
    private estadoIngresoMateriaPrimaService: EstadoIngresoMateriaPrimaService,

  ) {
    this.initForm()
  }

  ngOnInit() {
    this.ingreso = this.config.data.ingreso!;
    this.callback=this.config.data.callback
    if(this.ingreso){

      this.myForm.get("estado").setValue(this.ingreso?.currentState?.nombre);
    }

    this.myForm.get("estado").valueChanges.subscribe(data=>{
      if(data!=this.msjError) this.msjError=undefined;
    })
  }


  cancel(){
    this.ref.close()
  }
  save(){
    if(this.myForm.get("estado").value==this.ingreso.currentState.nombre){
      this.msjError="No le puede asignar el estado actual"
      return;
    }
    this.msjError=undefined;
    this.estadoIngresoMateriaPrimaService.post(this.ingreso.id!,{
      estado:this.myForm.get("estado").value,
      ingresoMateriaPrimaId:this.ingreso.id!
    }).subscribe(data=>{
      this.cancel()
      this.callback()
    })
  }

  initForm(){
    this.myForm = this.fb.group({
      estado:['', Validators.required]
    });
  }
}
