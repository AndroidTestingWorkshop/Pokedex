package gojek.pokedex.model;

import com.google.gson.annotations.SerializedName;

public class Pokemon {

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

    public Pokemon(String id, String name, String description, String imageUrl, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon pokemon = (Pokemon) o;

        if (id != null ? !id.equals(pokemon.id) : pokemon.id != null) return false;
        if (name != null ? !name.equals(pokemon.name) : pokemon.name != null) return false;
        if (description != null ? !description.equals(pokemon.description) : pokemon.description != null)
            return false;
        if (imageUrl != null ? !imageUrl.equals(pokemon.imageUrl) : pokemon.imageUrl != null)
            return false;
        return type != null ? type.equals(pokemon.type) : pokemon.type == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
