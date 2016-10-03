package gojek.pokedex.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import gojek.pokedex.R;
import gojek.pokedex.model.Pokemon;

public class PokemonDetailActivity extends AppCompatActivity implements PokemonDetailView {
    private ViewPager viewPagerPokemons;
    private int selectedPokemonId;
    private PokemonDetailPresenter pokemonDetailPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        initialize();
    }

    @Override
    public void onBackPressed() {
        pokemonDetailPresenter.onBackPressed(viewPagerPokemons.getCurrentItem(), selectedPokemonId);
    }

    @Override
    public void goToPokemonWithPosition(int item) {
        viewPagerPokemons.setCurrentItem(item);
    }

    @Override
    public void goBackToPokemonList() {
        super.onBackPressed();
    }

    private void initialize() {
        ArrayList<Pokemon> pokemons = getIntent().getParcelableArrayListExtra(Pokemon.TAG_LIST);
        selectedPokemonId = getIntent().getIntExtra(Pokemon.SELECTED_ID, 0);
        viewPagerPokemons = (ViewPager) findViewById(R.id.view_pager_pokemons);
        pokemonDetailPresenter = new PokemonDetailPresenter(this);
        PokemonsPagerAdapter pokemonsPagerAdapter = new PokemonsPagerAdapter(getSupportFragmentManager(), pokemons);
        viewPagerPokemons.setAdapter(pokemonsPagerAdapter);
        goToPokemonWithPosition(selectedPokemonId);
    }
}
