import { Component } from '@angular/core';
import { ThemeService } from '../../../services/theme.service';

@Component({
  selector: 'app-layout-page',
  templateUrl: './layout-page.component.html',
  styles: [
  ]
})
export class LayoutPageComponent {

  constructor(

    private themeService: ThemeService
  ){}

  toggleTheme(){
    this.themeService.toggleTheme();
  }

  get themeIcon(): string {
    return this.themeService.theme === 'light' ? 'pi pi-sun' : 'pi pi-moon'; // Emoji for illustration; replace with icon classes if needed
  }
}
