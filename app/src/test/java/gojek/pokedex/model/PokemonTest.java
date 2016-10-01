package gojek.pokedex.model;

import org.junit.Assert;
import org.junit.Test;

public class PokemonTest {
    @Test
    public void shouldNotBeEqualToNull() {
        Pokemon pokemon = new Pokemon("1", "Pikachu", "Pika Pika!", "http://example.com/pikachu.jpg", "ELECTRICITY");
        Assert.assertFalse(pokemon.equals(null));
    }

    @Test
    public void shouldBeEqualToOtherPikachuIfHasSameAttributes() {
        Pokemon pokemon = new Pokemon("1", "Pikachu", "Pika Pika!", "http://example.com/pikachu.jpg", "ELECTRICITY");
        Pokemon secondPokemon = new Pokemon("1", "Pikachu", "Pika Pika!", "http://example.com/pikachu.jpg", "ELECTRICITY");
        Assert.assertTrue(pokemon.equals(secondPokemon));
    }

    @Test
    public void shouldNotBeEqualToOtherPikachuIfHasDifferentAttributes() {
        Pokemon pokemon = new Pokemon("1", "Pikachu", "Pika Pika!", "http://example.com/pikachu.jpg", "ELECTRICITY");
        Pokemon secondPokemon = new Pokemon("2", "Raichu", "Raichu Raichu!", "http://example.com/raichu.jpg", "ELECTRICITY");
        Assert.assertFalse(pokemon.equals(secondPokemon));
    }

    @Test
    public void shouldNotBeEqualToAnyObjectOtherThanPikachu() {
        Pokemon pokemon = new Pokemon("1", "Pikachu", "Pika Pika!", "http://example.com/pikachu.jpg", "ELECTRICITY");
        Assert.assertFalse(pokemon.equals(new Object()));
    }

    @Test
    public void shouldHaveEqualHashCodeIfSameInBusinessContext() {
        Pokemon pokemon = new Pokemon("1", "Pikachu", "Pika Pika!", "http://example.com/pikachu.jpg", "ELECTRICITY");
        Pokemon secondPokemon = new Pokemon("1", "Pikachu", "Pika Pika!", "http://example.com/pikachu.jpg", "ELECTRICITY");
        int actualPikachuHashCode = pokemon.hashCode();
        int expectedPikachuHashCode = secondPokemon.hashCode();
        Assert.assertEquals(expectedPikachuHashCode, actualPikachuHashCode);
    }
}
