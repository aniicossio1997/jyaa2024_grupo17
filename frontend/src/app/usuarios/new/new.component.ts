import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SelectItem } from 'primeng/api';
import { Validators } from '@angular/forms';
import { UsuariosService } from '../usuarios.service';
import { Password } from 'primeng/password';
import { Router } from '@angular/router';
import { ManagementRoutes } from '../../routers';
import { ToastrService } from 'ngx-toastr';

@Component({
  providers: [UsuariosService],
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css'],
})
export class NewComponent implements OnInit {
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
      Validators.required,
      Validators.minLength(3),
    ]),
    email: new FormControl('', [Validators.required, Validators.email]),
    rol: new FormControl({ label: '', value: null }, Validators.required),
  });

  constructor(
    private usuariosService: UsuariosService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.form.value);
    const raw = this.form.getRawValue();
    const request = {
      nombre: raw.nombre,
      apellido: raw.apellido,
      username: raw.username,
      email: raw.email,
      rol: raw.rol.value,
      password: raw.rol.value,
    };
    this.loading = true;
    this.usuariosService.create(request).subscribe((res) => {
      this.toastr.success('Se ha agregado el usuario');
      this.router.navigate([
        '/' + ManagementRoutes.Usuario,
        ManagementRoutes.Query,
      ]);
    });
  }

  back() {
    this.router.navigate([
      '/' + ManagementRoutes.Usuario,
      ManagementRoutes.Query,
    ]);
  }
  ngOnInit() {}
}
