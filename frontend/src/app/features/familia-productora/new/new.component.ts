import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FamiliaProductoraService } from '../familia-productora.service';
import { catchError, of, switchMap } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { ManagementRoutes } from '../../../routers';
import { FamialiProductoraCreateViewModel } from '../../../interfaces/FamiliaProductoraCreateViewModel';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css'],
  providers:[FamiliaProductoraService]
})
export class NewComponent implements OnInit {
  myForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router,
    private familiaProductoraService:FamiliaProductoraService,
    private toastr: ToastrService,
  ) {
    this.myForm = this.fb.group({
      nombre: ['', Validators.required,],
      descripcion: ['']
    });
  }

  ngOnInit() {

  }

  cancel(){
    this.router.navigate(['/' + ManagementRoutes.FamiliaProductora]);

  }
  save(){
    if (this.myForm.valid) {

      const entityToAdd:FamialiProductoraCreateViewModel= {
            nombre:this.myForm.get("nombre").value,
            descripcion:this.myForm.get("descripcion").value
      }

      this.familiaProductoraService.post(entityToAdd).subscribe(
        result => {
          if (result) {

            this.cancel()
          }
        }
      );

    }

  }

}
