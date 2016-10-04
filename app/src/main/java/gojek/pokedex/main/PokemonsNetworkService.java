package gojek.pokedex.main;

import java.util.List;

import gojek.pokedex.model.Pokemon;
import gojek.pokedex.model.PokemonResponse;
import retrofit2.http.GET;
import rx.Observable;

public interface PokemonsNetworkService {
    @GET("pokemons")
    Observable<List<PokemonResponse>> loadPokemons();
}
