package gojek.pokedex.model;

import android.graphics.Color;
import android.support.annotation.ColorInt;

import gojek.pokedex.R;

public enum PokemonType {
    GRASS {
        public @ColorInt int color() {
            return resolve(R.color.type_grass);
        }
    },
    FIRE {
        public @ColorInt int color() {
            return resolve(R.color.type_fire);
        }
    },
    WATER {
        public @ColorInt int color() {
            return resolve(R.color.type_water);
        }
    },
    BUG {
        public @ColorInt int color() {
            return resolve(R.color.type_bug);
        }
    },
    NORMAL {
        public @ColorInt int color() {
            return resolve(R.color.type_normal);
        }
    },
    POISON {
        public @ColorInt int color() {
            return resolve(R.color.type_poison);
        }
    },
    ELECTRIC {
        public @ColorInt int color() {
            return resolve(R.color.type_electric);
        }
    },
    GROUND {
        public @ColorInt int color() {
            return resolve(R.color.type_ground);
        }
    },
    FAIRY {
        public @ColorInt int color() {
            return resolve(R.color.type_fairy);
        }
    },
    FIGHTING {
        public @ColorInt int color() {
            return resolve(R.color.type_fighting);
        }
    };

    public @ColorInt int color() {
        return this.color();
    }

    private static int resolve(int colorResource) {
        return Color.parseColor(String.valueOf(colorResource));
    }
}
