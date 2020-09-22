import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Trainer } from './trainer';
import { Observable } from 'rxjs';
import { Pokemon } from './pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokedexService {

  private baseUrl: string = "http://localhost:8081/PokeSpring";


  constructor(private http:  HttpClient) { }

  getAllTrainers(): Observable<Trainer[]> {
    return this.http.get<Trainer[]>(this.baseUrl + "/trainers");
  }

  getTrainer(id: number): Observable<Trainer> {
    return this.http.get<Trainer>(this.baseUrl + "/trainers/" + id);
  }

  addTrainer(t: Trainer): Observable<Trainer[]> {
    return this.http.post<Trainer[]>(this.baseUrl + "/trainers", t);
  }

  getPoke(id: number): Observable<any> {
    return this.http.get<any>("https://pokeapi.co/api/v2/pokemon/" + id);
  }

  addPoke(p: Pokemon): Observable<Trainer[]> {
    return this.http.post<Trainer[]>(this.baseUrl + "/pokemon", p);
  }
}
