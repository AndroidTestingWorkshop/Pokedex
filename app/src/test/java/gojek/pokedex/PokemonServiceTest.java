package gojek.pokedex;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class PokemonServiceTest {
    @Test
    public void testThatPokemonServiceKnowsHowToHandleNetworkIssues() {
        PokemonService pokemonService = new PokemonService();
        PokemonLoadCallback pokemonLoadCallback = Mockito.mock(PokemonLoadCallback.class);
        pokemonService.loadPokemons(pokemonLoadCallback);
        Mockito.verify(pokemonLoadCallback).onLoadFailed(Matchers.<NetworkError>any());
    }
}
