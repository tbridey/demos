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

  constructor(private pokeService: PokeService) { }

  ngOnInit(): void {
  }

  async fetchPage(): Promise<void> {
    this.pokemon = await this.pokeService.getPokemonPage(this.page);
  }
}
