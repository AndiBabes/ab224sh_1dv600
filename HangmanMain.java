package hangman;

import java.util.Scanner;

public class HangmanMain
{

	public static void printWord(boolean[] letters,String str)
	{
		for (int i = 0; i < letters.length; i++)
			if (letters[i])
				System.out.print(str.charAt(i));
			else System.out.print("_");
		System.out.println();
	}

	public static boolean checkWord(boolean[] word)
	{
		boolean check=true;
		for(int i=0;i<word.length;i++)
			if(!word[i])
			{
				check=false;
				break;
			}
		return check;
	}
	
	public static void main(String[] args)
	{
		String word = "test";
		boolean[] letters = new boolean[word.length()];
		int mistakes = 0;
		boolean stillPlaying = true;
		Scanner scan = new Scanner(System.in);
		while (stillPlaying)
		{
			printWord(letters,word);
			System.out.print("provide a letter: ");
			char guess = scan.next().charAt(0);
			boolean correct = false;
			for (int i = 0; i < letters.length; i++)
				if (word.charAt(i) == guess)
				{
					correct = true;
					letters[i]=true;
				}
			if (!correct)
				mistakes++;
			if (mistakes == 6 || checkWord(letters))
				stillPlaying = false;
		}
		scan.close();
		if(mistakes==6) System.out.println("you have lost");
		else System.out.println("you have won");
	}

}
