import { DOCUMENT } from '@angular/common';
import { Inject, Injectable, OnInit } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class ThemeService {
  private BASE_PATH = 'assets/themes/';
  private currentTheme = 'light';

  constructor(@Inject(DOCUMENT) private document: Document) {
    this.currentTheme = localStorage.getItem('theme') ?? 'light';
    this.switchTheme( this.currentTheme);
  }

  switchTheme(theme: string) {
    let themeLink = this.document.getElementById(
      'app-theme'
    ) as HTMLLinkElement;
    if (themeLink) {
      themeLink.href = this.BASE_PATH + theme + '.css';
    }
    this.currentTheme = theme;
  }

  toggleTheme() {
    const t = this.currentTheme;
    const next = t == 'light' ? 'dark' : 'light';
    localStorage.setItem('theme', next);
    this.switchTheme(next);
  }

  get theme() {
    return this.currentTheme;
  }
}
