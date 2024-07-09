import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UnidadMedidaEnum } from '../../../interfaces/UnidadMedidaEnum';
import InsumoViewModel from '../../../interfaces/InsumoViewModel';
import { ActivatedRoute, Router } from '@angular/router';
import { InsumosService } from '../../../services/insumo.service';
import { ManagementRoutes } from '../../../routers';
import { InsumoCreateViewModel } from '../../../interfaces/InsumoCreateViewModel';

@Component({
  selector: 'app-insumos-edit',
  templateUrl: './insumos-edit.component.html',
  styleUrl: './insumos-edit.component.scss',
  providers:[InsumosService]
})
export class InsumosEditComponent {

  myForm: FormGroup;

  unidadMedidaArray: string[] = Object.keys(UnidadMedidaEnum);

  insumo:InsumoViewModel

  constructor(private fb: FormBuilder, private router: Router,
    private insumosService:InsumosService, private activatedRouter:ActivatedRoute
  ) {
    this.myForm = this.fb.group({
      nombre: ['', Validators.required,],
      unidadMedida:['',Validators.required],
      descripcion: [''],
    });
  }

  ngOnInit() {

    const id = Number(this.activatedRouter.snapshot.paramMap.get('id')!);

    if(id){
      this.insumosService.getById(id!).subscribe(data=>{
        this.insumo={...data,cantidadDisponible:0}
        this.myForm.get("nombre").setValue(data.nombre),
        this.myForm.get("descripcion").setValue(data.descripcion);
        this.myForm.get("unidadMedida").setValue(data.unidadMedida);
        this.myForm.updateValueAndValidity(); // Actualiza las validaciones sincrónicas

      })
    }
  }

  cancel(){
    this.router.navigate(['/' + ManagementRoutes.Insumo]);

  }
  save(){
    if (this.myForm.valid) {

      const entityToAdd:InsumoCreateViewModel= {
            nombre:this.myForm.get("nombre").value,
            descripcion:this.myForm.get("descripcion").value,
            unidadMedida: this.myForm.get("unidadMedida").value
      }

      this.insumosService.put(this.insumo.id!,entityToAdd).subscribe(
        result => {
          if (result) {
            this.router.navigate([`/${ManagementRoutes.Insumo}/`]); // Usa item.id para redirigir

          }
        }
      );

    }

  }
}
