package gojek.pokedex.add;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gojek.pokedex.R;
import gojek.pokedex.model.PokemonType;

public class PokemonTypesAdapter extends RecyclerView.Adapter<PokemonTypeHolder> {
    private final PokemonType[] pokemonTypes;
    private Context context;

    public PokemonTypesAdapter(Context context) {
        this.context = context;
        pokemonTypes = new PokemonType[]{PokemonType.GRASS, PokemonType.FIRE, PokemonType.WATER, PokemonType.BUG, PokemonType.NORMAL, PokemonType.POISON, PokemonType.ELECTRIC, PokemonType.GROUND, PokemonType.FAIRY, PokemonType.FIGHTING};
    }

    @Override
    public PokemonTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pokemon_type, parent, false);
        return new PokemonTypeHolder(view, context);
    }

    @Override
    public void onBindViewHolder(PokemonTypeHolder holder, int position) {
        PokemonType pokemonType = pokemonTypes[position];
        holder.bind(pokemonType);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return pokemonTypes.length;
    }
}
