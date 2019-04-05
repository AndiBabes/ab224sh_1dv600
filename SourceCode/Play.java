package hangman;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Play
{
	private static String word = "testing";
	private static boolean[] letters;
	private static int score;
	private static int mistakes;

	public Play()
	{
		mistakes=0;
		letters = new boolean[word.length()];
		/*
		 * try { Random rand = new Random(); int n = rand.nextInt(6); File file = new
		 * File("WordList.txt"); Scanner scan = new Scanner(file); for (int i = 0; i <=
		 * n; i++) word = scan.nextLine(); letters = new boolean[word.length()];
		 * scan.close(); } catch (IOException e) { e.printStackTrace(); }
		 */		
	}

	public boolean stillPlaying()
	{
		if (mistakes < 6)
			for (int i = 0; i < letters.length; i++)
				if (letters[i] == false)
					return true;
		return false;

	}

	public void reset()
	{
		try
		{
			Random rand = new Random();
			int n = rand.nextInt(6);
			File file = new File("WordList.txt");
			Scanner scan = new Scanner(file);
			for (int i = 0; i <= n; i++)
				word = scan.nextLine();
			letters = new boolean[word.length()];
			scan.close();
			mistakes = 0;
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void play(char letter)
	{
		boolean correct = false;
		for (int i = 0; i < word.length(); i++)
			if (letter == word.charAt(i))
			{
				correct = true;
				letters[i] = true;
			}
		if (!correct)
			mistakes++;
	}

	public String getWord()
	{
		StringBuilder print = new StringBuilder();
		for (int i = 0; i < letters.length; i++)
			if (letters[i])
				print.append(word.charAt(i) + " ");
			else
				print.append("_ ");
		return print.toString();
	}

	public int getMistakes()
	{
		return mistakes;
	}

}
