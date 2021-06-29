import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { About } from './about'
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AboutService {

  readonly URL = "http://localhost:8080"

  demoUser: About = new About(0,"DEMO",20000)

  constructor(private http: HttpClient) {
   }

  get(id: number): Observable<About>{
    return this.http.get<About>(this.URL+'/user/'+id)
  }

  add(data: About): Observable<About>{
    return this.http.post<About>(this.URL+'/user',data,{responseType:'text' as 'json'})
  }
}
