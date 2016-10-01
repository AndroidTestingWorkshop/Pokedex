package gojek.pokedex;

import java.net.SocketTimeoutException;

public class PokemonService {
    public void loadPokemons(PokemonLoadCallback pokemonLoadCallback) {
        pokemonLoadCallback.onLoadFailed(new NetworkError(new SocketTimeoutException()));
    }
}
