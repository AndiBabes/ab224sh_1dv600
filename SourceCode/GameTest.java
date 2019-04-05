package hangman;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest
{
	char[] letters = { 't', 'e', 's', 'i', 'n', 'g' };

	@Test
	public void testPlayCountingMistakesWhenLosing()
	{
		Play sut = new Play();
		// the method being tested is Play.play()
		assertEquals(0, sut.getMistakes());
		for (int i = 0; i < 6; i++)
			sut.play('a');
		assertEquals(6, sut.getMistakes());
	}

	@Test
	public void testPlayCountingMistakesWhenWinning()
	{
		Play sut = new Play();
		// the method being tested is Play.play()
		assertEquals(0, sut.getMistakes());
		for (int i = 0; i < letters.length; i++)
			sut.play(letters[i]);
		assertEquals(0, sut.getMistakes());
	}

	@Test
	public void testGetWordWhenWinning()
	{
		Play sut = new Play();
		assertEquals("_ _ _ _ _ _ _ ", sut.getWord());
		// it's all underscores since no letter has been guessed yet
		sut.play('g');
		assertEquals("_ _ _ _ _ _ g ", sut.getWord());
		// the letter 'g' is correct so it is shown in the word
		for (int i = 0; i < letters.length; i++)
			sut.play(letters[i]);
		assertEquals("t e s t i n g ", sut.getWord());
		// all letters were guessed so all should be visibile
	}

	@Test
	public void testGetWordWhenLosing()
	{
		Play sut = new Play();
		assertEquals("_ _ _ _ _ _ _ ", sut.getWord());
		// it's all underscores since no letter has been guessed yet
		for (int i = 0; i < 6; i++)
			sut.play('a');
		assertEquals("_ _ _ _ _ _ _ ", sut.getWord());
		// no letters were guessed correctly and the game has been lost
	}

	@Test
	public void testStillPlaying()
	{
		Play sut = new Play();
		// checks if the game is still playing
		assertEquals(true, sut.stillPlaying());
		// should be true since no letter has been played
		for (int i = 0; i < 7; i++)
			sut.play('a');
		assertEquals(false, sut.stillPlaying());
	}

}
