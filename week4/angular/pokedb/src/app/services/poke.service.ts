import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pokemon } from '../models/pokemon';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokeService {

  constructor(private http: HttpClient) { }

  public getPokemon(id: string | number): Observable<Pokemon> {
    return this.http.get<Pokemon>('https://pokeapi.co/api/v2/pokemon/' + id);
  }

  public async getPokemonPage(page: number): Promise<Pokemon[]> {
    if(page !== 0 && !page) {
      throw new Error("Invalid Pokemon Page input");
    }
    // Take care to prevent bad input

    let offset: number = 20 * page;

    let { results } = await this.http.get<{ results: {name: string, url: string}[] }>('https://pokeapi.co/api/v2/pokemon', {
      params: {
        offset: '' + offset,
        limit: '' + 20
      }
    }).toPromise();

    let promiseArr = [];
    for(let obj of results) {
      let pokemonPromise = this.http.get<Pokemon>(obj.url).toPromise();
      promiseArr.push(pokemonPromise);
    }

    let pokemonFromPage = await Promise.all<Pokemon>(promiseArr);

    return pokemonFromPage;
  }
}
