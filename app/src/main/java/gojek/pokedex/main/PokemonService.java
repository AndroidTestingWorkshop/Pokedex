package gojek.pokedex.main;

import java.util.ArrayList;
import java.util.List;

import gojek.pokedex.common.NetworkError;
import gojek.pokedex.model.Pokemon;
import gojek.pokedex.model.PokemonResponse;
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
                subscribe(new Subscriber<List<PokemonResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        pokemonLoadCallback.onLoadFailed(new NetworkError(e));
                    }

                    @Override
                    public void onNext(List<PokemonResponse> pokemonResponses) {
                        List<Pokemon> pokemons = new ArrayList<>();
                        for (PokemonResponse pokemonResponse : pokemonResponses)
                            pokemons.add(pokemonResponse.toPokemon());
                        pokemonLoadCallback.onLoadSuccess(pokemons);
                    }
                });
    }
}
