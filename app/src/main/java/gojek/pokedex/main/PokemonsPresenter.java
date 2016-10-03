package gojek.pokedex.main;

import java.util.List;

import gojek.pokedex.common.NetworkError;
import gojek.pokedex.model.Pokemon;

public class PokemonsPresenter {

    private PokemonsView view;
    private PokemonService pokemonService;

    public PokemonsPresenter(PokemonsView view, PokemonService pokemonService) {
        this.view = view;
        this.pokemonService = pokemonService;
    }

    public void loadPokemons() {
        pokemonService.loadPokemons(new PokemonLoadCallback() {
            @Override
            public void onLoadFailed(NetworkError expectedError) {
                view.showError(expectedError.getMessage());
            }

            @Override
            public void onLoadSuccess(List<Pokemon> pokemons) {
                view.showPokemons(pokemons);
            }
        });
    }
}
