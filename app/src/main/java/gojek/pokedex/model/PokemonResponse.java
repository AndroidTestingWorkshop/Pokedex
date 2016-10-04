package gojek.pokedex.model;

import com.google.gson.annotations.SerializedName;

public class PokemonResponse {
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("description")
    public String description;
    @SerializedName("image_url")
    public String imageUrl;
    @SerializedName("type")
    public String type;

    @SuppressWarnings("unused")
    public PokemonResponse() {
    }

    public Pokemon toPokemon() {
        return new Pokemon(id, name, description, imageUrl, PokemonType.valueOf(type));
    }
}
