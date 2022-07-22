package lmoreno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HunderGamesTest {
    @Test
    public void example() {
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};

        assertArrayEquals(expected, HunderGames.whoEatsWho(input));
    }
    @Test
    public void eatRightMulti() {
        final String input = "fox,chicken,sheep,grass,sheep";
        final String[] expected = 	{
                "fox,chicken,sheep,grass,sheep",
                "fox eats chicken",
                "fox eats sheep",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};

        assertArrayEquals(expected, HunderGames.whoEatsWho(input));
    }
    @Test
    public void eatLeftMulti() {
        final String input = "sheep,bug,chicken,grass,sheep,grass,fox";
        final String[] expected = 	{
                "sheep,bug,chicken,grass,sheep,grass,fox",
                "chicken eats bug",
                "sheep eats grass",
                "sheep eats grass",
                "fox eats sheep",
                "fox eats chicken",
                "fox eats sheep",
                "fox"};

        assertArrayEquals(expected, HunderGames.whoEatsWho(input));
    }
    @Test
    public void Crazy() {
        final String input = "wale,cow,grass,giraffe,leaves,lion,fox,bug,bear,chicken,antelope,grass,big-fish,little-fish,grass,sheep";
        final String[] expected = 	{
                "wale,cow,grass,giraffe,leaves,lion,fox,bug,bear,chicken,antelope,grass,big-fish,little-fish,grass,sheep",
                "cow eats grass",
                "giraffe eats leaves",
                "bear eats bug",
                "bear eats chicken",
                "antelope eats grass",
                "big-fish eats little-fish",
                "sheep eats grass",
                "wale,cow,giraffe,lion,fox,bear,antelope,big-fish,sheep"};

        assertArrayEquals(expected, HunderGames.whoEatsWho(input));
    }

}
