package gojek.pokedex.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Pokemon implements Parcelable {
    public static final String TAG_LIST = "gojek.pokedex.model.PokemonList";
    public static final String SELECTED_ID = "gojek.pokedex.model.Pokemon.SELECTED_ID";
    public static final String TAG = "gojek.pokedex.model.Pokemon.TAG";

    public String id;
    public String name;
    public String description;
    @SerializedName("image_url")
    public String imageUrl;
    public PokemonType type;

    public Pokemon(String id, String name, String description, String imageUrl, PokemonType type) {
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
        return type == pokemon.type;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.imageUrl);
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
    }

    protected Pokemon(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.imageUrl = in.readString();
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : PokemonType.values()[tmpType];
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel source) {
            return new Pokemon(source);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };
}
