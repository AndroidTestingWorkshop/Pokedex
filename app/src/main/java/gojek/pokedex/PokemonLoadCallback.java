package gojek.pokedex;

public interface PokemonLoadCallback {
    void onLoadFailed(NetworkError expectedError);
}
