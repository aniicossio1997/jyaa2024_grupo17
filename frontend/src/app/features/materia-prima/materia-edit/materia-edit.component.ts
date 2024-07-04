import { Component } from '@angular/core';
import { ManagementRoutes } from '../../../routers';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { MateriaPrimaCreateViewModel } from '../../../interfaces/MateriaPrimaCreateViewModel';
import { UnidadMedidaEnum } from '../../../interfaces/UnidadMedidaEnum';
import { Menu } from 'primeng/menu';
import { MenuItem } from 'primeng/api';
import { MateriaPrimaViewModel } from '../../../interfaces/MateriaPrimaViewModel';


enum formKeysEnum{
  nombre= "nombre",
  unidadMedida= "unidadMedida",
  descripcion="descripcion"
}

@Component({
  selector: 'app-materia-edit',
  templateUrl: './materia-edit.component.html',
  styleUrl: './materia-edit.component.scss',
  providers:[MateriaPrimaService]
})
export class MateriaEditComponent {

  myForm: FormGroup;

  unidadMedidaArray: string[] = Object.keys(UnidadMedidaEnum);

  itemsMenu: MenuItem[] = [];
  materiaPrima:MateriaPrimaViewModel

  constructor(private fb: FormBuilder, private router: Router,
    private materiaPrimaService:MateriaPrimaService, private activatedRouter:ActivatedRoute
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
      this.materiaPrimaService.getById(id!).subscribe(data=>{
        this.materiaPrima=data;
        this.myForm.get("nombre").setValue(data.nombre),
        this.myForm.get("descripcion").setValue(data.descripcion);
        this.myForm.get(formKeysEnum.unidadMedida).setValue(data.unidadMedida);
        // Marcar controles como tocados para forzar la actualización de validaciones
        this.myForm.get("nombre").markAsTouched();
        this.myForm.get("descripcion").markAsTouched();

        this.myForm.updateValueAndValidity(); // Actualiza las validaciones sincrónicas

      })
    }
  }

  cancel(){
    this.router.navigate(['/' + ManagementRoutes.MateriaPrima]);

  }
  save(){
    if (this.myForm.valid) {

      const entityToAdd:MateriaPrimaCreateViewModel= {
            nombre:this.myForm.get("nombre").value,
            descripcion:this.myForm.get("descripcion").value,
            unidadMedida: this.myForm.get(formKeysEnum.unidadMedida).value
      }

      this.materiaPrimaService.put(this.materiaPrima.id!,entityToAdd).subscribe(
        result => {
          if (result) {
            this.router.navigate([`/${ManagementRoutes.MateriaPrima}/${ManagementRoutes.Gestion}/`, this.materiaPrima.id]); // Usa item.id para redirigir


          }
        }
      );

    }

  }



  generateMenu(item: any, menu: Menu, event: any) {
    menu.toggle(event);

    this.itemsMenu = [
      {
        label: 'Editar',
        icon: 'pi pi-pencil',
        command: () => {
          //this.router.navigate([`/${ManagementRoutes.FamiliaProductora}/${ManagementRoutes.Edit}/`, item.id]); // Usa item.id para redirigir

        },
      },
      {
        label: 'Eliminar',
        icon: 'pi pi-trash',
        command: () => {
          //this.delete(item);
        },
      },

    ];
  }

}
