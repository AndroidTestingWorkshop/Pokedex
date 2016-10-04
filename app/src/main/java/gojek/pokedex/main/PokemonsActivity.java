package gojek.pokedex.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import gojek.pokedex.PokedexApplication;
import gojek.pokedex.R;
import gojek.pokedex.add.AddPokemonActivity;
import gojek.pokedex.detail.PokemonDetailActivity;
import gojek.pokedex.model.Pokemon;

public class PokemonsActivity extends AppCompatActivity implements PokemonsView {
    private PokemonsAdapter pokemonsAdapter;
    private RecyclerView listPokemons;
    private FloatingActionButton fabAdd;
    private PokemonsPresenter pokemonsPresenter;

    @Inject
    public PokemonService pokemonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((PokedexApplication) getApplication()).getPokedexComponent().inject(this);
        initialize();
    }

    @Override
    public void showPokemons(List<Pokemon> pokemons) {
        pokemonsAdapter.setPokemons(pokemons);
    }

    @Override
    public void showError(String message) {
    }

    private void initialize() {
        listPokemons = (RecyclerView) findViewById(R.id.list_pokemons);
        listPokemons.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        pokemonsAdapter = new PokemonsAdapter(this, getOnPokemonClickListener());
        listPokemons.setAdapter(pokemonsAdapter);
        pokemonsPresenter = new PokemonsPresenter(this, pokemonService);
        pokemonsPresenter.loadPokemons();
        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(fabAddOnClickListener());
    }

    private View.OnClickListener fabAddOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPokemonIntent = new Intent(PokemonsActivity.this, AddPokemonActivity.class);
                PokemonsActivity.this.startActivity(addPokemonIntent);
            }
        };
    }

    @NonNull
    private OnPokemonClickListener getOnPokemonClickListener() {
        return new OnPokemonClickListener() {
            @Override
            public void onPokemonClick(int id) {
                ArrayList<Pokemon> pokemons = pokemonsAdapter.getPokemons();
                Intent pokemonDetailIntent = new Intent(PokemonsActivity.this, PokemonDetailActivity.class);
                pokemonDetailIntent.putParcelableArrayListExtra(Pokemon.TAG_LIST, pokemons);
                pokemonDetailIntent.putExtra(Pokemon.SELECTED_ID, id);
                PokemonsActivity.this.startActivity(pokemonDetailIntent);
            }
        };
    }
}
