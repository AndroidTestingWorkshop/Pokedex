package gojek.pokedex.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import gojek.pokedex.R;
import gojek.pokedex.model.Pokemon;

public class PokemonsAdapter extends RecyclerView.Adapter<PokemonViewHolder> {
    private final ArrayList<Pokemon> pokemonsList;
    private Context context;
    private OnPokemonClickListener onPokemonClickListener;

    public PokemonsAdapter(Context context, OnPokemonClickListener onPokemonClickListener) {
        this.context = context;
        this.onPokemonClickListener = onPokemonClickListener;
        this.pokemonsList = new ArrayList<>();
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonsList.get(position);
        holder.setOnClickListener(position, onPokemonClickListener);
        holder.bind(pokemon.name, pokemon.type);
    }

    @Override
    public int getItemCount() {
        return pokemonsList.size();
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemonsList.clear();
        this.pokemonsList.addAll(pokemons);
        notifyDataSetChanged();
    }

    public ArrayList<Pokemon> getPokemons() {
        return this.pokemonsList;
    }
}
