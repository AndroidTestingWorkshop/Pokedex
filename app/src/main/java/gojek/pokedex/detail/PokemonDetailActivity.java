package gojek.pokedex.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import gojek.pokedex.R;
import gojek.pokedex.model.Pokemon;

public class PokemonDetailActivity extends AppCompatActivity {
    private ViewPager viewPagerPokemons;
    private int selectedPokemonId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        viewPagerPokemons = (ViewPager) findViewById(R.id.view_pager_pokemons);

        ArrayList<Pokemon> pokemons = getIntent().getParcelableArrayListExtra(Pokemon.TAG_LIST);
        selectedPokemonId = getIntent().getIntExtra(Pokemon.SELECTED_ID, 0);

        PokemonsPagerAdapter pokemonsPagerAdapter = new PokemonsPagerAdapter(getSupportFragmentManager(), pokemons);
        viewPagerPokemons.setAdapter(pokemonsPagerAdapter);
        viewPagerPokemons.setCurrentItem(selectedPokemonId);
    }

    @Override
    public void onBackPressed() {
        int currentItem = viewPagerPokemons.getCurrentItem();
        if (currentItem <= selectedPokemonId) {
            super.onBackPressed();
        } else {
            viewPagerPokemons.setCurrentItem(currentItem - 1);
        }
    }
}
