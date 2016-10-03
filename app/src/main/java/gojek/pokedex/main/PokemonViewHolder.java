package gojek.pokedex.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import gojek.pokedex.R;
import gojek.pokedex.main.OnPokemonClickListener;

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    private final TextView textPokemonName;
    private final TextView textPokemonType;
    private View itemView;

    public PokemonViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        textPokemonName = (TextView) itemView.findViewById(R.id.text_pokemon_name);
        textPokemonType = (TextView) itemView.findViewById(R.id.text_pokemon_type);
    }

    public void bind(String name, String type) {
        textPokemonName.setText(name);
        textPokemonType.setText(type);
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
