package gojek.pokedex.dependencies;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gojek.pokedex.PokemonService;
import gojek.pokedex.PokemonsNetworkService;
import gojek.pokedex.R;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public Retrofit providesRetrofit(Context context) {
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public PokemonsNetworkService providesPokemonNetworkService(Retrofit retrofit) {
        return retrofit.create(PokemonsNetworkService.class);
    }

    @Provides
    @Singleton
    public PokemonService providesPokemonService(PokemonsNetworkService pokemonsNetworkService) {
        return new PokemonService(pokemonsNetworkService);
    }
}
