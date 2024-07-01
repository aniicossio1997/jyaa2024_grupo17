import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrl: './shell.component.scss'
})
export class ShellComponent  implements OnInit{
  isResponsive: boolean=false;
  menuActive!: boolean;


  ngOnInit(): void {

    this.menuActive = this.isStatic() && !this.isMobile();
  }
  isMobile() {
    return window.innerWidth <= 980;
  }

  isStatic() {
    return true;
  }

  setSidebarVisible() {
    this.isResponsive = !this.isResponsive;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    console.log("CAMBIANDO window.innerWidth <= 991", window.innerWidth <= 991)
    this.isResponsive= window.innerWidth <= 991;
  }
}
