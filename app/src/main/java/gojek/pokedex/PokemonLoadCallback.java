package gojek.pokedex;

import java.util.List;

import gojek.pokedex.model.Pokemon;

public interface PokemonLoadCallback {
    void onLoadFailed(NetworkError expectedError);

    void onLoadSuccess(List<Pokemon> pokemons);
}
