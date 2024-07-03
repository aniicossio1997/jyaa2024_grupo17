import { Directive, ElementRef, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ValidationErrors } from '@angular/forms';

@Directive({
  selector: '[customLabel]'
})
export class CustomLabelDirective implements OnInit, OnChanges {

  private htmlElement?: ElementRef<HTMLElement>;
  private _color: string = 'red';
  private _errors?: ValidationErrors | null;
  private _valueForm:string=null!;

  @Input() set color( value: string ) {
    this._color = value;
    this.setStyle();
  }

  @Input() set errors( value: ValidationErrors | null | undefined ) {
    this._errors = value;

  }
  @Input() set valueForm( value: string ) {
    if(value && value!=""){

      this._valueForm = value;
      this.setErrorMessage();
    }


  }

  constructor( private el: ElementRef<HTMLElement> ) {
    this.htmlElement = el;
  }

  ngOnInit(): void {
    this.setStyle();
  }


  setStyle():void {
    if ( !this.htmlElement )return;

    this.htmlElement!.nativeElement.style.color = this._color;
  }

  setErrorMessage():void {
    if ( !this.htmlElement )return;
    if ( !this._errors || !this._valueForm) {
      this.htmlElement.nativeElement.innerText = '';
      return;
    }

    const errors = Object.keys(this._errors);

    if ( errors.includes('required') )  {
      this.htmlElement.nativeElement.innerText = 'Este campo es requerido.';
      return;
    }

    if ( errors.includes('minlength') )  {
      const min = this._errors!['minlength']['requiredLength'];
      const current = this._errors!['minlength']['actualLength'];

      this.htmlElement.nativeElement.innerText = `Mínimo ${current}/${ min } caracteres.`;
      return;
    }

    if ( errors.includes('email') )  {
      this.htmlElement.nativeElement.innerText = 'No tiene formato de correo.';
      return;
    }



  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes ) {
      this.setErrorMessage();
    }
  }

}
