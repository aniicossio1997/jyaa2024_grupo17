import { Component, OnInit } from '@angular/core';
import { FamiliaProductoraService } from '../familia-productora.service';

@Component({
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrl: './query.component.scss',
  providers:[FamiliaProductoraService]
})
export class QueryComponent  implements OnInit{


  constructor(private familiaProductoraService: FamiliaProductoraService){

  }

  ngOnInit(): void {
    console.log("HELLO")
    this.familiaProductoraService.get().subscribe(data=>{
      console.log("DATA COMPONENT::", data)
    })
  }

}
