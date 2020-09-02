import { Component, OnInit } from '@angular/core';
import { PokeService } from 'src/app/services/poke.service';
import { Pokemon } from '../models/pokemon';

@Component({
  selector: 'app-pokelist',
  templateUrl: './pokelist.component.html',
  styleUrls: ['./pokelist.component.css']
})
export class PokelistComponent implements OnInit {

  public page: number = 0;
  public pokemon: Pokemon[] = [];
  public search: string = "";
  public currentTime: number = new Date().getTime();

  constructor(private pokeService: PokeService) { }

  ngOnInit(): void {
    setInterval( () => {
      this.currentTime = new Date().getTime();
    }, 1000);
  }

  async fetchPage(): Promise<void> {
    this.pokemon = await this.pokeService.getPokemonPage(this.page);
  }
}
