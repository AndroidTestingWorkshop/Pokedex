package gojek.pokedex.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import gojek.pokedex.PokedexApplication;
import gojek.pokedex.PokemonService;
import gojek.pokedex.PokemonsAdapter;
import gojek.pokedex.R;
import gojek.pokedex.model.Pokemon;

public class PokemonsActivity extends AppCompatActivity implements PokemonsView {
    private PokemonsAdapter pokemonsAdapter;
    private RecyclerView listPokemons;

    @Inject
    public PokemonService pokemonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((PokedexApplication) getApplication()).getPokedexComponent().inject(this);
        listPokemons = (RecyclerView) findViewById(R.id.list_pokemons);
        listPokemons.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        pokemonsAdapter = new PokemonsAdapter(this);
        listPokemons.setAdapter(pokemonsAdapter);
        PokemonsPresenter pokemonsPresenter = new PokemonsPresenter(this, pokemonService);
        pokemonsPresenter.loadPokemons();
    }

    @Override
    public void showPokemons(List<Pokemon> pokemons) {
        pokemonsAdapter.setPokemons(pokemons);
    }

    @Override
    public void showError(String message) {
    }
}
