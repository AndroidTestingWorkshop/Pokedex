package gojek.pokedex;

import java.util.List;

import gojek.pokedex.model.PokemonType;

public class AddPokemonPresenter {
    private AddPokemonView view;

    public AddPokemonPresenter(AddPokemonView view) {
        this.view = view;
    }

    public void addPokemonDetails(String pokemonName, List<PokemonType> pokemonTypes, String pokemonDescription) {
        view.showPopupError("Name should not be empty");
    }
}
