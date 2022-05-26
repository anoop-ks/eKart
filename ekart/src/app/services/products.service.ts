import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http"
@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  addtocart(prod_id: any, user_id: any) {
    return this.http.get(this.url+"8000/addtocart/"+prod_id,user_id);
  }
  
  
  constructor(private http: HttpClient) { }

  url:string = "http://localhost:";

  getProductByname(prodName:string) {
    return this.http.get(this.url + "8000/search/"+prodName);
  }

  getdeals(){
    return  this.http.get(this.url+"8000/deals");
  }
  
  getrecomendations(){
    return this.http.get(this.url+"8000/curated");
  }
  
}
