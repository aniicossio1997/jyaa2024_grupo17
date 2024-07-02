import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SelectItem } from 'primeng/api';
import { Validators } from '@angular/forms';
import { UsuariosService } from '../usuarios.service';
import { Router } from '@angular/router';
import { ManagementRoutes } from '../../routers';
import { ToastrService } from 'ngx-toastr';
import { UsuarioViewModel } from '../../interfaces/UsuarioViewModel';
import { RolUsuario } from '../../model/RolUsuario';

@Component({
  providers: [UsuariosService],
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {
  usuario: UsuarioViewModel;

  roles: SelectItem[] = [
    { label: 'Administrador', value: 'ADMIN' },
    { label: 'Encargado de Sala', value: 'ENCARGADO_SALA' },
  ];
  rol = 'ADMIN';
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
    private toastr: ToastrService
  ) {}

  ngOnInit() {
    this.usuariosService.detail(1).subscribe((res) => {
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
      this.toastr.success('Se han guardado los cambios el usuario');
      this.router.navigate([
        '/' + ManagementRoutes.Usuario,
        ManagementRoutes.Query,
      ]);
    });
  }

  setRol(rol: RolUsuario) {
    this.form.get('rol').setValue(rol);
  }

  back() {
    this.router.navigate([
      '/' + ManagementRoutes.Usuario,
      ManagementRoutes.Query,
    ]);
  }
}
