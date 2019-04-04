package hangman;

import java.util.Scanner;

public class HangmanMain
{
	
	public static void main(String[] args)
	{
		Play play=new Play();
		Scanner scan=new Scanner(System.in);
		while(play.stillPlaying())
		{
			System.out.println(play.getWord());
			System.out.println(play.getMistakes() + " mistakes");
			System.out.print("letter: ");
			play.play(scan.next().charAt(0));
		}
	}

}
