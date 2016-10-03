package gojek.pokedex.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import gojek.pokedex.detail.PokemonFragment;
import gojek.pokedex.model.Pokemon;

public class PokemonsPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<Pokemon> pokemons;

    public PokemonsPagerAdapter(FragmentManager fm, ArrayList<Pokemon> pokemons) {
        super(fm);
        this.pokemons = pokemons;
    }

    @Override
    public Fragment getItem(int position) {
        Pokemon pokemon = pokemons.get(position);
        PokemonFragment pokemonDetailFragment = new PokemonFragment();
        Bundle pokemonDetailFragmentArguments = new Bundle();
        pokemonDetailFragmentArguments.putParcelable(Pokemon.TAG, pokemon);
        pokemonDetailFragment.setArguments(pokemonDetailFragmentArguments);
        return pokemonDetailFragment;
    }

    @Override
    public int getCount() {
        return pokemons.size();
    }
}
