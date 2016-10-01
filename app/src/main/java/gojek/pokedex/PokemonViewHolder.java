package gojek.pokedex;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    private final TextView textPokemonName;
    private final TextView textPokemonType;

    public PokemonViewHolder(View itemView) {
        super(itemView);
        textPokemonName = (TextView) itemView.findViewById(R.id.text_pokemon_name);
        textPokemonType = (TextView) itemView.findViewById(R.id.text_pokemon_type);
    }

    public void bind(String name, String type) {
        textPokemonName.setText(name);
        textPokemonType.setText(type);
    }
}
