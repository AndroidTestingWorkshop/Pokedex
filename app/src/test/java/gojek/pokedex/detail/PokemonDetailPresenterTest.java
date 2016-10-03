package gojek.pokedex.detail;

import org.junit.Test;
import org.mockito.Mockito;

public class PokemonDetailPresenterTest {
    @Test
    public void testThatItGoesToPokemonListOnBackPressWhenItIsBehindThePokemonItSelectedOnThePokemonDetailPage() {
        PokemonDetailView pokemonDetailView = Mockito.mock(PokemonDetailView.class);
        PokemonDetailPresenter presenter = new PokemonDetailPresenter(pokemonDetailView);
        presenter.onBackPressed(9, 10);
        Mockito.verify(pokemonDetailView).goBackToPokemonList();
    }

    @Test
    public void testThatItGoesToPokemonListOnBackPressWhenItIsOnThePokemonItSelectedOnThePokemonDetailPage() {
        PokemonDetailView pokemonDetailView = Mockito.mock(PokemonDetailView.class);
        PokemonDetailPresenter presenter = new PokemonDetailPresenter(pokemonDetailView);
        presenter.onBackPressed(10, 10);
        Mockito.verify(pokemonDetailView).goBackToPokemonList();
    }

    @Test
    public void testThatItGoesToLastSeenPokemonOnBackPressWhenItIsAheadOfPokemonItSelectedOnThePokemonDetailPage() {
        PokemonDetailView pokemonDetailView = Mockito.mock(PokemonDetailView.class);
        PokemonDetailPresenter presenter = new PokemonDetailPresenter(pokemonDetailView);
        presenter.onBackPressed(11, 10);
        Mockito.verify(pokemonDetailView).goToPokemonWithPosition(10);
    }
}
