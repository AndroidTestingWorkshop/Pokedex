package gojek.pokedex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import gojek.pokedex.main.PokemonsPresenter;
import gojek.pokedex.main.PokemonsView;
import gojek.pokedex.model.Pokemon;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PokemonsPresenterTest {

    private PokemonsPresenter presenter;

    @Mock
    PokemonsView view;
    @Mock
    PokemonService pokemonService;

    @Before
    public void setUp() throws Exception {
        presenter = new PokemonsPresenter(view, pokemonService);
    }

    @Test
    public void testShouldShowTheListOfPokemonsWhenServerReturnsCorrectData() throws Exception {
        final List<Pokemon> pokemons = new Fixture("pokemons.json").loadList(Pokemon[].class);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((PokemonLoadCallback) invocation.getArguments()[0]).onLoadSuccess(pokemons);
                return null;
            }
        }).when(pokemonService).loadPokemons(Matchers.<PokemonLoadCallback>any());
        presenter.loadPokemons();
        verify(view).showPokemons(pokemons);
    }
}