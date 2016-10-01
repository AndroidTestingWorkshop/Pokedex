package gojek.pokedex;

import java.util.List;

import gojek.pokedex.model.Pokemon;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PokemonService {
    private PokemonsNetworkService pokemonsNetworkService;

    public PokemonService(PokemonsNetworkService pokemonsNetworkService) {
        this.pokemonsNetworkService = pokemonsNetworkService;
    }

    public void loadPokemons(final PokemonLoadCallback pokemonLoadCallback) {
        pokemonsNetworkService.loadPokemons().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<List<Pokemon>>() {
                              @Override
                              public void onCompleted() {

                              }

                              @Override
                              public void onError(Throwable e) {
                                  pokemonLoadCallback.onLoadFailed(new NetworkError(e));
                              }

                              @Override
                              public void onNext(List<Pokemon> pokemons) {
                                  pokemonLoadCallback.onLoadSuccess(pokemons);
                              }
                          }
                );
    }
}
