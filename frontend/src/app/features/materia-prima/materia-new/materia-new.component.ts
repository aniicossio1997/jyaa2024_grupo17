import { Component } from '@angular/core';
import { ManagementRoutes } from '../../../routers';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MateriaPrimaService } from '../../../services/materia-prima.service';
import { MateriaPrimaCreateViewModel } from '../../../interfaces/MateriaPrimaCreateViewModel';
import { UnidadMedidaEnum } from '../../../interfaces/UnidadMedidaEnum';
import { Menu } from 'primeng/menu';
import { MenuItem } from 'primeng/api';
enum formKeysEnum{
  nombre= "nombre",
  unidadMedida= "unidadMedida",
  descripcion="descripcion"
}

@Component({
  selector: 'app-materia-new',
  templateUrl: './materia-new.component.html',
  styleUrl: './materia-new.component.scss',
  providers:[MateriaPrimaService]
})
export class MateriaNewComponent {
  myForm: FormGroup;

  unidadMedidaArray: string[] = [];
  itemsMenu: MenuItem[] = [];


  constructor(private fb: FormBuilder, private router: Router,
    private materiaPrimaService:MateriaPrimaService,
  ) {
    this.myForm = this.fb.group({
      nombre: ['', Validators.required,],
      unidadMedida:['',Validators.required],
      descripcion: [''],
    });
  }

  ngOnInit() {
    this.enumToArray()
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

      this.materiaPrimaService.post(entityToAdd).subscribe(
        result => {
          if (result) {

            this.cancel()
          }
        }
      );

    }

  }

  enumToArray() {

    this.unidadMedidaArray = Object.keys(UnidadMedidaEnum);

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
