package gojek.pokedex.detail;

public class PokemonDetailPresenter {
    private PokemonDetailView pokemonDetailView;

    public PokemonDetailPresenter(PokemonDetailView pokemonDetailView) {
        this.pokemonDetailView = pokemonDetailView;
    }

    public void onBackPressed(int currentItem, int selectedPokemonId) {
        if (currentItem <= selectedPokemonId) {
            pokemonDetailView.goBackToPokemonList();
        } else {
            pokemonDetailView.goToPokemonWithPosition(currentItem - 1);
        }
    }
}
