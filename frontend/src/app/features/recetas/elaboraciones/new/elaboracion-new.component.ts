import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UnidadMedidaEnum } from '../../../../interfaces/UnidadMedidaEnum';
import { ActivatedRoute, Router } from '@angular/router';
import { ManagementRoutes } from '../../../../routers';
import { RecetasService } from '../../../../services/recetas.service';
import { RecetaDetalleViewModel } from '../../../../interfaces/RecetaDetalleViewModel';
import InsumoViewModel from '../../../../interfaces/InsumoViewModel';
import IngredienteViewModel from '../../../../interfaces/IngredienteViewModel';

@Component({
  selector: 'app-insumos-new',
  templateUrl: './elaboracion-new.component.html',
  providers:[RecetasService]
})
export class ElaboracionNewComponent implements OnInit{
  recetaId:number;
  receta:RecetaDetalleViewModel;
  insumos:IngredienteViewModel[];
  materiasPrimas: IngredienteViewModel[];

  form: FormGroup;

  unidadMedidaArray: string[] = Object.keys(UnidadMedidaEnum);

  constructor(private fb: FormBuilder, private router: Router,
    private recetaService:RecetasService,  private activatedRoute:ActivatedRoute
  ) {
      this.initForm()
      this.recetaId = Number(this.activatedRoute.snapshot.paramMap.get('id')!);
  }

  ngOnInit(): void {
    this.recetaService.detail(this.recetaId).subscribe(res => {
      this.receta = res
      this.insumos = res.ingredientes.filter(i => i.insumo != null);
      this.materiasPrimas = res.ingredientes.filter(i => i.materiaPrima != null);
    });
  }

  initForm(){
    this.form = this.fb.group({
      cantidad: [1, Validators.required,],
      nota: [''],
    });
  }

  cancel(){
    this.router.navigate(['/' + ManagementRoutes.Receta + "/" + 1]);

  }
  save(){
   
  }

  getMin(a: number, b: number): number {
    return Math.min(a, b);
  }
}
