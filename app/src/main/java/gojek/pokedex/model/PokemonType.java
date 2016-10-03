package gojek.pokedex.model;

import android.graphics.Color;
import android.support.annotation.ColorInt;

public enum PokemonType {
    ELECTRICITY {
        public @ColorInt int color() {
            return Color.YELLOW;
        }
    },
    GRASS {
        public @ColorInt int color() {
            return Color.GREEN;
        }
    };

    public @ColorInt int color() {
        return this.color();
    }
}
