import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AboutService } from './about.service'
import { About } from "./about";

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  readonly URL = "localhost:8080/user"
  id: number = 0
  result: About = {}
  data: About = {}
  name: string = ""
  salary: number = 0

  constructor(private aboutService: AboutService) { 
  }

  ngOnInit(): void {
  }

  get() {
    this.aboutService.get(this.id).subscribe((res)=>this.result=res)
  }
  add() {
    this.data = {
      name: this.name,
      salary: this.salary
    }
    this.aboutService.add(this.data).subscribe(()=>console.log("ADD"))
  }
}
