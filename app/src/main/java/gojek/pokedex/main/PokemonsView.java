package gojek.pokedex.main;

import java.util.List;

import gojek.pokedex.model.Pokemon;

public interface PokemonsView {
    void showPokemons(List<Pokemon> pokemons);
}
