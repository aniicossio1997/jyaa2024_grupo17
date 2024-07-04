import { Injectable } from '@angular/core';
import { ConfirmationService } from 'primeng/api';

@Injectable()
export default class ConfirmationDialogService {
  constructor(private confirmationService: ConfirmationService) {}

  confirmDelete(message: string, onConfirm: () => void) {
    this.confirmationService.confirm({
      message: message,
      header: 'Confirmar la Eliminación',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon: 'none',
      rejectIcon: 'none',
      key: 'positionDialog',
      acceptButtonStyleClass: 'p-button-danger p-button-text ',
      rejectButtonStyleClass: 'p-button-secondary p-button-text',
      accept: () => {
        onConfirm();
      },
      reject: () => {},
    });
  }
}
