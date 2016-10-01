package gojek.pokedex;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.net.SocketTimeoutException;
import java.util.List;

import gojek.pokedex.model.Pokemon;
import rx.Observable;

public class PokemonServiceTest {
    private PokemonsNetworkService pokemonsNetworkService;

    @Before
    public void setup() {
        pokemonsNetworkService = Mockito.mock(PokemonsNetworkService.class);
    }

    @Test
    public void testThatPokemonServiceKnowsHowToHandleNetworkIssues() {
        Mockito.doReturn(Observable.error(new SocketTimeoutException())).when(pokemonsNetworkService).loadPokemons();
        PokemonService pokemonService = new PokemonService(pokemonsNetworkService);
        PokemonLoadCallback pokemonLoadCallback = Mockito.mock(PokemonLoadCallback.class);
        pokemonService.loadPokemons(pokemonLoadCallback);
        Mockito.verify(pokemonLoadCallback).onLoadFailed(Matchers.<NetworkError>any());
    }

    @Test
    public void testThatPokemonServiceKnowsHowToReceiveListOfPokemons() {
        List<Pokemon> pokemons = new Fixture("pokemons.json").loadList(Pokemon[].class);
        Mockito.when(pokemonsNetworkService.loadPokemons()).thenReturn(Observable.just(pokemons));
        PokemonService pokemonService = new PokemonService(pokemonsNetworkService);
        PokemonLoadCallback pokemonLoadCallback = Mockito.mock(PokemonLoadCallback.class);
        pokemonService.loadPokemons(pokemonLoadCallback);
        Mockito.verify(pokemonLoadCallback).onLoadSuccess(pokemons);
    }
}
