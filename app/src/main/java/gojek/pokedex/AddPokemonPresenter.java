package gojek.pokedex;

import java.util.List;

import gojek.pokedex.model.PokemonType;

public class AddPokemonPresenter {
    private AddPokemonView view;

    public AddPokemonPresenter(AddPokemonView view) {
        this.view = view;
    }

    public void addPokemonDetails(String pokemonName, List<PokemonType> pokemonTypes, String pokemonDescription) {
        if (pokemonName == null || pokemonName.length() < 1) {
            view.showPopupError("Name should not be empty");
            return;
        }
        if (pokemonDescription == null || pokemonDescription.length() < 1) {
            view.showPopupError("Description should not be empty");
            return;
        }
        if (pokemonTypes == null || pokemonTypes.size() < 1) {
            view.showPopupError("Should pick at least 1 type");
            return;
        }
        view.showPopupError("Should pick maximum 2 types");
    }
}
