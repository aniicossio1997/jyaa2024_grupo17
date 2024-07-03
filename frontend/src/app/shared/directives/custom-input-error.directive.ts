import { Directive, ElementRef, HostListener, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ValidationErrors } from '@angular/forms';
import { Observable } from 'rxjs';

@Directive({
  selector: '[appCustomInputError]',
})
export class CustomInputErrorDirective implements OnInit, OnChanges{

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


  constructor( private el: ElementRef<HTMLElement>) {
    this.htmlElement = el;
  }
  ngOnChanges(changes: SimpleChanges): void {
    if (changes ) {
      this.setErrorMessage();
    }
  }

  ngOnInit(): void {
    this.setStyle();

  }



  setStyle(): void {
    if (!this.htmlElement) return;

    //this.htmlElement!.nativeElement.style.borderColor = this._color;
  }

  setErrorMessage(): void {
    //console.log("SET ERROR:: value", this._valueForm, this._errors)


    if (!this.htmlElement) return;


    if (!this._errors) {
      //this.htmlElement.nativeElement.style.borderColor = '#10b981';
      this.htmlElement.nativeElement.classList.remove('invalid');

      return;
    }
    const errors = Object.keys(this._errors!);
    if (errors.includes('required')) {
      this.htmlElement.nativeElement.classList.add('invalid');

      //this.htmlElement.nativeElement.style.border = `1px solid ${this._color}`;
      return;
    }


  }

 /* @HostListener('focus')
  onFocus(): void {
    this.setErrorMessage();
  }

  @HostListener('blur')
  onBlur(): void {
    this.setErrorMessage();
  }
    */
 }
