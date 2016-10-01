package gojek.pokedex;

import android.app.Application;

import gojek.pokedex.dependencies.AppModule;
import gojek.pokedex.dependencies.DaggerPokedexComponent;
import gojek.pokedex.dependencies.PokedexComponent;

public class PokedexApplication extends Application {
    private PokedexComponent pokedexComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        pokedexComponent = DaggerPokedexComponent.
                builder().
                appModule(new AppModule(this)).
                build();
    }

    public PokedexComponent getPokedexComponent() {
        return pokedexComponent;
    }
}
