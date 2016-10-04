package gojek.pokedex.add;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import gojek.pokedex.R;
import gojek.pokedex.model.PokemonType;

public class PokemonTypeHolder extends RecyclerView.ViewHolder {
    private final TextView textPokemonType;
    private final Context context;

    public PokemonTypeHolder(View itemView, Context context) {
        super(itemView);
        textPokemonType = (TextView) itemView.findViewById(R.id.text_pokemon_type);
        this.context = context;
    }

    public void bind(PokemonType pokemonType) {
        textPokemonType.setText(pokemonType.name());
        textPokemonType.setBackgroundColor(context.getResources().getColor(pokemonType.color()));
    }
}
