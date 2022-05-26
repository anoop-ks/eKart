import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RegisterService } from '../services/register-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private regService : RegisterService) { }

  ngOnInit(): void {
    this.registerform = new FormGroup({
      username: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required]),
      cpassword: new FormControl('',[Validators.required])
    });
  }
  registerform !: FormGroup
  gotoLogin = false;



  
  register(){
    if(this.registerform.value.password == this.registerform.value.cpassword){
      this.regService.postreg(this.registerform.value).subscribe({
        next: (data:any) => {console.log("data fetched : "+ JSON.stringify(data));},
        error: (error:any) => {console.log(error.message)},
        complete: () => {alert("Registered!!!")}
      });
    }
    else{
      alert("Passwords dont match ")
    }


  }

}
