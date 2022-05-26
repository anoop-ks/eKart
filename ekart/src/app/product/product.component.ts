import { Component, OnInit } from '@angular/core';
import { product1 } from './product';
import {ProductsService} from "../services/products.service"
import { deal } from './deal';
import { DatashareService } from '../services/datashare.service';
import { user } from '../login/user';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  logout:boolean = false;

  constructor(private dataService : DatashareService ,private proService : ProductsService) { }
  User!:user;
  ngOnInit(): void {
    this.getdeals();
    this.getrecomendations();
    this.dataService.value.subscribe(
      data=>{this.User = data}
    );

  }
  searchResult !: any;
  searcherror:boolean = false;
  prodName !:string;
  searchflag=false;
  searchclick(event : Event, searchterm : any) {
    this.searcherror=false;
    //Enter is pressed after typing product name in search box
    alert("Fetching Data...")
    searchterm = searchterm.replace(/\s/g, "").toLowerCase();
    console.log("search term is : "+searchterm)
    this.proService.getProductByname(searchterm).subscribe({
      next: (data) => {
        console.log("data is fetched : "+JSON.stringify(data));this.searchflag=true;  this.searchResult = data},
      error: (error) => {console.log(error.message);this.searcherror=true;}
    });
    //Apple iPad Mini 2
    //search by product name
  }

  getdetails(prodname:string) {
    this.searcherror=false;
    //Enter is pressed after typing product name in search box
    console.log("search term is : "+prodname)
    //prodname = prodname.replace(/\s/g, "").toLowerCase();
    this.proService.getProductByname(prodname).subscribe({
      next: (data) => {
        console.log("data is fetched : "+JSON.stringify(data));this.searchflag=true;  this.searchResult = data},
      error: (error) => {console.log(error.message);this.searcherror=true;}
    });
    //Apple iPad Mini 2
    //search by product name
  }


  dealserror:boolean = false;
  deals!: any;

  getdeals() {
    this.dealserror=false;
    this.proService.getdeals().subscribe({
      next: (data) => {
        console.log("data is fetched : "+JSON.stringify(data)); this.deals = data},
      error: (error) => {console.log(error.message);this.dealserror=true;}
    });
  }

  curatederror:boolean = false;
  curated!: any;

  getrecomendations() {
    this.curatederror=false;
    this.proService.getrecomendations().subscribe({
      next: (data) => {
        console.log("data is fetched : "+JSON.stringify(data)); this.curated = data},
      error: (error) => {console.log(error.message);this.curatederror=true;}
    });
  }
  clicked : boolean = false;

  addtocart(pid : any){
    this.proService.addtocart( pid, this.User.id).subscribe({
      next: (data) => {
        console.log("data is fetched : "+JSON.stringify(data)); this.curated = data},
      error: (error) => {console.log(error.message);this.curatederror=true;}
    });
  }
  goback(){
    this.clicked = false;
    this.searchflag = false
  }
}
