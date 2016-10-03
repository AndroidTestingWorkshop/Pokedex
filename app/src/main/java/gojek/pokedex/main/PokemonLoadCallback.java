package gojek.pokedex.main;

import java.util.List;

import gojek.pokedex.common.NetworkError;
import gojek.pokedex.model.Pokemon;

public interface PokemonLoadCallback {
    void onLoadFailed(NetworkError expectedError);

    void onLoadSuccess(List<Pokemon> pokemons);
}
