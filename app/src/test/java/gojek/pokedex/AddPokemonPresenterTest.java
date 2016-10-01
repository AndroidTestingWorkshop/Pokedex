package gojek.pokedex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import gojek.pokedex.model.PokemonType;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddPokemonPresenterTest {

    @Mock
    AddPokemonView view;
    private AddPokemonPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new AddPokemonPresenter(view);
    }

    @Test
    public void testShouldShowNameErrorIfNameIsEmpty() {
        List<PokemonType> pokemonTypes = new ArrayList<>();
        pokemonTypes.add(new PokemonType());
        String errorMessage = "Name should not be empty";
        presenter.addPokemonDetails(null, pokemonTypes, "some valid description");
        verify(view).showPopupError(errorMessage);
    }
}
