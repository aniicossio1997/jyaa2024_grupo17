import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UnidadMedidaEnum } from '../../../interfaces/UnidadMedidaEnum';
import { Router } from '@angular/router';
import { InsumosService } from '../../../services/insumo.service';
import { ManagementRoutes } from '../../../routers';
import { InsumoCreateViewModel } from '../../../interfaces/InsumoCreateViewModel';

@Component({
  selector: 'app-insumos-new',
  templateUrl: './insumos-new.component.html',
  styleUrl: './insumos-new.component.scss',
  providers:[InsumosService]
})
export class InsumosNewComponent implements OnInit{
  myForm: FormGroup;

  unidadMedidaArray: string[] = Object.keys(UnidadMedidaEnum);

  constructor(private fb: FormBuilder, private router: Router,
    private insumosService:InsumosService,
  ) {
      this.initForm()
  }

  ngOnInit(): void {

  }

  initForm(){
    this.myForm = this.fb.group({
      nombre: ['', Validators.required,],
      unidadMedida:['',Validators.required],
      descripcion: [''],
    });
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

      this.insumosService.post(entityToAdd).subscribe(
        result => {
          if (result) {
            this.cancel()
          }
        }
      );

    }

  }
}
