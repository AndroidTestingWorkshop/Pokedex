package gojek.pokedex;

import java.net.SocketTimeoutException;
import java.util.List;

import gojek.pokedex.model.Pokemon;
import rx.Observable;
import rx.Subscriber;

public class PokemonService {
    private PokemonsNetworkService pokemonsNetworkService;

    public PokemonService(PokemonsNetworkService pokemonsNetworkService) {
        this.pokemonsNetworkService = pokemonsNetworkService;
    }

    public void loadPokemons(final PokemonLoadCallback pokemonLoadCallback) {
        Observable<List<Pokemon>> pokemonsObservable = pokemonsNetworkService.loadPokemons();
        pokemonsObservable.subscribe(new Subscriber<List<Pokemon>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                pokemonLoadCallback.onLoadFailed(new NetworkError(new SocketTimeoutException()));
            }

            @Override
            public void onNext(List<Pokemon> pokemons) {
                pokemonLoadCallback.onLoadSuccess(pokemons);
            }
        });
    }
}
