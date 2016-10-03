package gojek.pokedex.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gojek.pokedex.R;
import gojek.pokedex.model.Pokemon;

public class PokemonFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Pokemon pokemon = getArguments().getParcelable(Pokemon.TAG);
        TextView textPokemonName = (TextView) view.findViewById(R.id.text_pokemon_name);
        textPokemonName.setText(pokemon.name);
    }
}
