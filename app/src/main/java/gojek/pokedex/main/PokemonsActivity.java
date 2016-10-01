package gojek.pokedex.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import gojek.pokedex.PokedexApplication;
import gojek.pokedex.PokemonService;
import gojek.pokedex.R;
import gojek.pokedex.model.Pokemon;

public class PokemonsActivity extends AppCompatActivity implements PokemonsView {
    @Inject
    public PokemonService pokemonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((PokedexApplication) getApplication()).getPokedexComponent().inject(this);
        PokemonsPresenter pokemonsPresenter = new PokemonsPresenter(this, pokemonService);
        pokemonsPresenter.loadPokemons();
    }

    @Override
    public void showPokemons(List<Pokemon> pokemons) {
    }

    @Override
    public void showError(String message) {
    }
}
