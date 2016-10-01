package gojek.pokedex;

import java.util.List;

import gojek.pokedex.model.Pokemon;
import retrofit2.http.GET;
import rx.Observable;

public interface PokemonsNetworkService {
    @GET("pokemons")
    Observable<List<Pokemon>> loadPokemons();
}
