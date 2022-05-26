import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { user } from '../login/user';
@Injectable({
  providedIn: 'root'
})
export class DatashareService {

  constructor() { }
  data !:user;
  private UserSource =  new BehaviorSubject<user>(this.data);
  value = this.UserSource.asObservable()
  changeuser(data: user) {
   this.UserSource.next(data);
  }
}
  
