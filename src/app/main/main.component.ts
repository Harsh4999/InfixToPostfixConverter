import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ConSService } from './con-s.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  public ans:string='';
  constructor(private cons:ConSService) { }

  ngOnInit(): void {
  }
  calc(d:NgForm){
    console.log(d.value.str);
    this.cons.getDate(d.value.str).subscribe(
      (res)=>{
        console.log(res);
      },
      (err)=>{
        console.log(err.error.text);
        this.ans=err.error.text;
      }
    )
  }

}
