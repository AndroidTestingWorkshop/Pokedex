package gojek.pokedex.main;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import gojek.pokedex.R;
import gojek.pokedex.model.PokemonType;

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    private final TextView textPokemonName;
    private final TextView textPokemonType;
    private Resources resources;
    private View itemView;

    public PokemonViewHolder(View itemView, Resources resources) {
        super(itemView);
        this.resources = resources;
        this.itemView = itemView;
        textPokemonName = (TextView) itemView.findViewById(R.id.text_pokemon_name);
        textPokemonType = (TextView) itemView.findViewById(R.id.text_pokemon_type);
    }

    public void bind(String name, PokemonType type) {
        textPokemonName.setText(name);
        textPokemonType.setText(type.toString());
        textPokemonType.setBackgroundColor(resources.getColor(type.color()));
    }

    public void setOnClickListener(final int position, final OnPokemonClickListener onPokemonClickListener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPokemonClickListener.onPokemonClick(position);
            }
        });
    }
}
