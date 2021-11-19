import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConSService {

  constructor(private http:HttpClient) { }

  getDate(s:string){
    return this.http.get(`http://localhost:8080/calc/${s}`);
  }
}
