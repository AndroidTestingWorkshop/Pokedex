package gojek.pokedex.add;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import gojek.pokedex.R;
import gojek.pokedex.model.PokemonType;

public class PokemonTypesAdapter extends BaseAdapter {
    private final PokemonType[] pokemonTypes;
    private Context context;

    public PokemonTypesAdapter(Context context) {
        this.context = context;
        pokemonTypes = new PokemonType[]{PokemonType.ELECTRICITY, PokemonType.GRASS};
    }

    @Override
    public int getCount() {
        return pokemonTypes.length;
    }

    @Override
    public PokemonType getItem(int position) {
        return pokemonTypes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layoutItemPokemonType;
        if (convertView == null)
            layoutItemPokemonType = LayoutInflater.from(context).inflate(R.layout.item_pokemon_type, parent, false);
        else
            layoutItemPokemonType = convertView;

        PokemonType pokemonType = getItem(position);
        layoutItemPokemonType.setTag(pokemonType);
        TextView textPokemonType = (TextView) layoutItemPokemonType.findViewById(R.id.text_pokemon_type);
        textPokemonType.setText(pokemonType.name());
        textPokemonType.setBackgroundColor(pokemonType.color());
        return layoutItemPokemonType;
    }
}
