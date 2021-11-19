import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConSService {

  constructor(private http:HttpClient) { }

  getDate(s:string){
    return this.http.get(`https://infixtopostfixbackend.herokuapp.com/calc/${s}`);
  }
}
