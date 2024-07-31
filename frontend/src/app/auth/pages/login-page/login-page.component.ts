import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ThemeService } from '../../../services/theme.service';
import { Message, MessageService } from 'primeng/api';
import { Subscription } from 'rxjs';
import { ManagementRoutes } from '../../../routers';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.scss',
  providers:[MessageService]
})
export class LoginPageComponent implements OnInit, OnDestroy {

  subs:Subscription=new Subscription();

  loginForm: FormGroup;
    messages: Message[] | undefined=[
      { severity: 'error',  detail: 'Usuario o contraseña incorrectos' },
  ];



  constructor(
    public authService: AuthService,
    private router: Router,
    private fb: FormBuilder,

  ){}
  ngOnDestroy(): void {
    this.subs?.unsubscribe();
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onLogin(): void {
    this.subs.add(
      this.authService.login({
        password:this.loginForm.get('password').value,
        username:this.loginForm.get('username').value
      })
        .subscribe( user => {

          if(user){
            this.router.navigate([
              '/' + ManagementRoutes.Usuario,
              ManagementRoutes.Query,
            ]);
          }

        })
    );

  }



}
