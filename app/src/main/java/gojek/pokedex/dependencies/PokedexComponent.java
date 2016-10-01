package gojek.pokedex.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import gojek.pokedex.main.PokemonsActivity;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface PokedexComponent {
    void inject(PokemonsActivity pokemonsActivity);
}
