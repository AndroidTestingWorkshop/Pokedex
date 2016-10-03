package gojek.pokedex.add;

import java.util.ArrayList;
import java.util.List;

import gojek.pokedex.model.PokemonType;

public class AddPokemonPresenter {
    private AddPokemonView view;
    private List<PokemonType> selectedPokemonTypes;

    public AddPokemonPresenter(AddPokemonView view) {
        this.view = view;
        selectedPokemonTypes = new ArrayList<>();
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
        if (pokemonTypes.size() > 2) {
            view.showPopupError("Should pick maximum 2 types");
            return;
        }
        view.showSuccessNotification();
    }

    public void onPokemonTypeClick(PokemonType pokemonType) {
        if (selectedPokemonTypes.contains(pokemonType))
            selectedPokemonTypes.remove(pokemonType);
        else
            selectedPokemonTypes.add(pokemonType);
    }
}
