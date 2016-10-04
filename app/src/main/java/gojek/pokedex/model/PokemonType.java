package gojek.pokedex.model;

import android.support.annotation.ColorRes;

import gojek.pokedex.R;

public enum PokemonType {
    GRASS {
        public @ColorRes
        int color() {
            return R.color.type_grass;
        }
    },
    FIRE {
        public @ColorRes int color() {
            return R.color.type_fire;
        }
    },
    WATER {
        public @ColorRes int color() {
            return R.color.type_water;
        }
    },
    BUG {
        public @ColorRes int color() {
            return R.color.type_bug;
        }
    },
    NORMAL {
        public @ColorRes int color() {
            return R.color.type_normal;
        }
    },
    POISON {
        public @ColorRes int color() {
            return R.color.type_poison;
        }
    },
    ELECTRIC {
        public @ColorRes int color() {
            return R.color.type_electric;
        }
    },
    GROUND {
        public @ColorRes int color() {
            return R.color.type_ground;
        }
    },
    FAIRY {
        public @ColorRes int color() {
            return R.color.type_fairy;
        }
    },
    FIGHTING {
        public @ColorRes int color() {
            return R.color.type_fighting;
        }
    };

    public @ColorRes int color() {
        return this.color();
    }
}
