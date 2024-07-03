import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SelectItem } from 'primeng/api';
import { Validators } from '@angular/forms';
import { UsuariosService } from '../usuarios.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UsuarioViewModel } from '../../../interfaces/UsuarioViewModel';
import { RolUsuario } from '../../../model/RolUsuario';
import { ManagementRoutes } from '../../../routers';


@Component({
  providers: [UsuariosService],
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {
  usuario: UsuarioViewModel;
  id:number;
  roles: SelectItem[] = [
    { label: 'Administrador', value: 'ADMIN' },
    { label: 'Encargado de Sala', value: 'ENCARGADO_SALA' },
  ];
  rol = null;
  loading = false;

  form = new FormGroup({
    nombre: new FormControl('', Validators.required),
    apellido: new FormControl('', Validators.required),
    username: new FormControl('', Validators.required),
    password: new FormControl('', [
      Validators.minLength(3),
    ]),
    email: new FormControl('', [Validators.required, Validators.email]),
    rol: new FormControl('', Validators.required),
  });

  constructor(
    private usuariosService: UsuariosService,
    private router: Router,
    private toastr: ToastrService,
    private activatedRoute:ActivatedRoute
  ) {
    this.id = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
  }

  ngOnInit() {
    this.usuariosService.detail(this.id).subscribe((res) => {
      this.usuario = res;
      this.form.setValue({
        nombre: res.nombre,
        apellido: res.apellido,
        password: '',
        email: res.email,
        username: res.username,
        rol: res.rol,
      });
    });
  }

  onSubmit() {
    const raw = this.form.getRawValue();
    let request: Partial<UsuarioViewModel> = {
      nombre: raw.nombre,
      apellido: raw.apellido,
      username: raw.username,
      email: raw.email,
      rol: raw.rol as RolUsuario,
    };
    if (raw.password) {
      request.password = raw.password;
    }

    this.loading = true;
    this.usuariosService.edit(this.usuario.id, request).subscribe(() => {
      this.toastr.success('Se han guardado los cambios');
      this.router.navigate([
        '/' + ManagementRoutes.Usuario,
        ManagementRoutes.Query,
      ]);
    });
  }

  setRol(rol: RolUsuario) {
    this.form.get('rol')!.setValue(rol);
  }

  back() {
    this.router.navigate([
      '/' + ManagementRoutes.Usuario,
      ManagementRoutes.Query,
    ]);
  }
}
