import { ValidationErrors } from "@angular/forms";

export interface FormValueError{
  validations: ValidationErrors
  value:any
}
