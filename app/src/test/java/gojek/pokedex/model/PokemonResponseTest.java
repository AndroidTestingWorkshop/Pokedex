package gojek.pokedex.model;

import junit.framework.Assert;

import org.junit.Test;

import java.io.IOException;

import gojek.pokedex.Fixture;

public class PokemonResponseTest {
    @Test
    public void testThatItKnowsHowToParseAGrassPokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_grass.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("1", "Bulbasaur", "While it is young, it uses the nutrients that are stored in the seeds on its back in order to grow.", "https://img.pokemondb.net/artwork/bulbasaur.jpg", PokemonType.GRASS);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testThatItKnowsHowToParseAFirePokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_fire.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("4", "Charmander", "If it's healthy, the flame on the tip of its tail will burn vigorously, even if it gets a bit wet.", "https://img.pokemondb.net/artwork/charmander.jpg", PokemonType.FIRE);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testThatItKnowsHowToParseAWaterPokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_water.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("7", "Squirtle", "Shoots water at prey while in the water. Withdraws into its shell when in danger.", "https://img.pokemondb.net/artwork/squirtle.jpg", PokemonType.WATER);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testThatItKnowsHowToParseABugPokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_bug.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("10", "Caterpie", "If you touch the feeler on top of its head, it will release a horrible stink to protect itself.", "https://img.pokemondb.net/artwork/caterpie.jpg", PokemonType.BUG);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testThatItKnowsHowToParseANormalPokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_normal.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("16", "Pidgey", "A common sight in forests and woods. It flaps its wings at ground level to kick up blinding sand.", "https://img.pokemondb.net/artwork/pidgey.jpg", PokemonType.NORMAL);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testThatItKnowsHowToParseAPoisonPokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_poison.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("23", "Ekans", "A very common sight in grassland, etc. It flicks its tongue in and out to sense danger in its surroundings.", "https://img.pokemondb.net/artwork/ekans.jpg", PokemonType.POISON);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testThatItKnowsHowToParseAElectricPokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_electric.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("25", "Pikachu", "It keeps its tail raised to monitor its surroundings. If you yank its tail, it will try to bite you.", "https://img.pokemondb.net/artwork/pikachu.jpg", PokemonType.ELECTRIC);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testThatItKnowsHowToParseAGroundPokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_ground.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("27", "Sandshrew", "It burrows and lives underground. If threatened, it curls itself up into a ball for protection.", "https://img.pokemondb.net/artwork/sandshrew.jpg", PokemonType.GROUND);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testThatItKnowsHowToParseAFairyPokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_fairy.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("35", "Clefairy", "The moonlight that it stores in the wings on its back apparently gives it the ability to float in midair.", "https://img.pokemondb.net/artwork/clefairy.jpg", PokemonType.FAIRY);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testThatItKnowsHowToParseAFightingPokemon() throws IOException {
        PokemonResponse pokemonResponse = new Fixture("pokemon_type_fighting.json").load(PokemonResponse.class);
        Pokemon actualPokemon = pokemonResponse.toPokemon();
        Pokemon expectedPokemon = new Pokemon("56", "Mankey", "Extremely quick to anger. It could be docile one moment, then thrashing away the next instant.", "https://img.pokemondb.net/artwork/mankey.jpg", PokemonType.FIGHTING);
        Assert.assertEquals(expectedPokemon, actualPokemon);
    }
}
