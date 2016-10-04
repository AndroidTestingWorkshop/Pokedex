package gojek.pokedex.model;

import junit.framework.Assert;

import org.junit.Test;

import gojek.pokedex.R;

public class PokemonTypeInstrumentationTest {
    @Test
    public void testThatItKnowsTheColorForTypeGrass() {
        Assert.assertEquals(R.color.type_grass, PokemonType.GRASS.color());
    }

    @Test
    public void testThatItKnowsTheColorForTypeFire() {
        Assert.assertEquals(R.color.type_fire, PokemonType.FIRE.color());
    }

    @Test
    public void testThatItKnowsTheColorForTypeWater() {
        Assert.assertEquals(R.color.type_water, PokemonType.WATER.color());
    }

    @Test
    public void testThatItKnowsTheColorForTypeBug() {
        Assert.assertEquals(R.color.type_bug, PokemonType.BUG.color());
    }

    @Test
    public void testThatItKnowsTheColorForTypeNormal() {
        Assert.assertEquals(R.color.type_normal, PokemonType.NORMAL.color());
    }

    @Test
    public void testThatItKnowsTheColorForTypePoison() {
        Assert.assertEquals(R.color.type_poison, PokemonType.POISON.color());
    }

    @Test
    public void testThatItKnowsTheColorForTypeElectric() {
        Assert.assertEquals(R.color.type_electric, PokemonType.ELECTRIC.color());
    }

    @Test
    public void testThatItKnowsTheColorForTypeGround() {
        Assert.assertEquals(R.color.type_ground, PokemonType.GROUND.color());
    }

    @Test
    public void testThatItKnowsTheColorForTypeFairy() {
        Assert.assertEquals(R.color.type_fairy, PokemonType.FAIRY.color());
    }

    @Test
    public void testThatItKnowsTheColorForTypeFighting() {
        Assert.assertEquals(R.color.type_fighting, PokemonType.FIGHTING.color());
    }
}
