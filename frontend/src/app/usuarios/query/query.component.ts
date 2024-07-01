import { Component, OnInit, ViewChild } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { NameableViewModel } from '../../interfaces/NameableViewModel';
import { MenuItem } from 'primeng/api';
import { Table } from 'primeng/table';

@Component({
  providers: [UsuariosService],
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrl: './query.component.scss',
})
export class QueryComponent implements OnInit {
  usuarios: NameableViewModel[] = [];

  // Menus
  actions: MenuItem[] = [
    {
      label: 'Detalle',
      icon: 'pi pi-refresh',
    },
    {
      label: 'Editar',
      icon: 'pi pi-upload',
    },
  ];

  // COsas raras de angular
  @ViewChild('dt') dt: Table | undefined;
  
  constructor(private usuariosService: UsuariosService) {}
  ngOnInit(): void {
    this.usuariosService.get().subscribe((res) => (this.usuarios = res));
  }

  applyFilterGlobal($event: any, stringVal: any) {
    this.dt!.filterGlobal(($event.target as HTMLInputElement).value, stringVal);
  }
}
