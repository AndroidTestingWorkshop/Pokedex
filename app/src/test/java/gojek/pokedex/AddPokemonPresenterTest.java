package gojek.pokedex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import gojek.pokedex.add.AddPokemonPresenter;
import gojek.pokedex.add.AddPokemonView;
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
    public void testShouldShowNameErrorIfNameIsNull() {
        List<PokemonType> pokemonTypes = new ArrayList<>();
        pokemonTypes.add(PokemonType.ELECTRIC);
        String errorMessage = "Name should not be empty";
        presenter.addPokemonDetails(null, pokemonTypes, "some valid description");
        verify(view).showPopupError(errorMessage);
    }

    @Test
    public void testShouldShowDescriptionErrorIfDescriptionIsNull() throws Exception {
        List<PokemonType> pokemonTypes = new ArrayList<>();
        pokemonTypes.add(PokemonType.GRASS);
        String errorMessage = "Description should not be empty";
        presenter.addPokemonDetails("asd", pokemonTypes, null);
        verify(view).showPopupError(errorMessage);
    }

    @Test
    public void testShouldShowNameErrorIfNameIsEmptyString() {
        List<PokemonType> pokemonTypes = new ArrayList<>();
        pokemonTypes.add(PokemonType.GRASS);
        String errorMessage = "Name should not be empty";
        presenter.addPokemonDetails("", pokemonTypes, "some valid description");
        verify(view).showPopupError(errorMessage);
    }

    @Test
    public void testShouldShowDescriptionErrorIfDescriptionIsEmptyString() throws Exception {
        List<PokemonType> pokemonTypes = new ArrayList<>();
        pokemonTypes.add(PokemonType.GRASS);
        String errorMessage = "Description should not be empty";
        presenter.addPokemonDetails("asd", pokemonTypes, "");
        verify(view).showPopupError(errorMessage);
    }

    @Test
    public void testShouldShowEmptyTypesErrorWhenPokemonTypesIsNull() throws Exception {
        String errorMessage = "Should pick at least 1 type";
        presenter.addPokemonDetails("asd", null, "aaaa");
        verify(view).showPopupError(errorMessage);
    }

    @Test
    public void testShouldShowEmptyTypesErrorWhenPokemonTypesIsEmpty() throws Exception {
        List<PokemonType> pokemonTypes = new ArrayList<>();
        String errorMessage = "Should pick at least 1 type";
        presenter.addPokemonDetails("asd", pokemonTypes, "aaaa");
        verify(view).showPopupError(errorMessage);
    }

    @Test
    public void testShouldShowMaximumTypesExceededWhenPokemonTypesCountIsMoreThanTwo() throws Exception {
        List<PokemonType> pokemonTypes = new ArrayList<>();
        pokemonTypes.add(PokemonType.GRASS);
        pokemonTypes.add(PokemonType.GRASS);
        pokemonTypes.add(PokemonType.GRASS);
        String errorMessage = "Should pick maximum 2 types";
        presenter.addPokemonDetails("asd", pokemonTypes, "aaaa");
        verify(view).showPopupError(errorMessage);
    }

    @Test
    public void testShouldShowSuccessfulNotificationWhenFieldsAreValid() throws Exception {
        List<PokemonType> pokemonTypes = new ArrayList<>();
        pokemonTypes.add(PokemonType.GRASS);
        pokemonTypes.add(PokemonType.GRASS);
        presenter.addPokemonDetails("asd", pokemonTypes, "aaaa");
        verify(view).showSuccessNotification();
    }
}
