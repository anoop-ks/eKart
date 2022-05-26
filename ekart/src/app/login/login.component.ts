import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import {user} from './user'
import { DatashareService } from '../services/datashare.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private dataService : DatashareService, private loginservice : LoginService, private router: Router) { }

  ngOnInit(): void {
    this.loginform = new FormGroup({
      username: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required])
    });
  }
  gotoReg = false;
  loginform!: FormGroup;
  User!: user;
  LoginSuccess:boolean = false;
  
  completeLogin(): boolean{
    console.log(this.loginform.value);
    this.loginservice.postlogin(this.loginform.value).subscribe({
      next: (data) => {console.log("data fetched : "+ JSON.stringify(data));
      if(data==null){
        alert("Login Failed")
        this.router.navigate(['/login']);
      }
      this.User = data;
    console.log("your id is :" + this.User.id)
    },
      error: (error) => {console.log(error.message)},
      complete: () => {this.LoginSuccess = true;
        this.sendUser();
      console.log(this.LoginSuccess); return true;}
    }); 

    return false; 
  }

  sendUser(){
    this.dataService.changeuser(this.User);
  }
}
