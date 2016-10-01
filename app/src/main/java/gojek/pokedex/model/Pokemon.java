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
}
