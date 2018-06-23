package hangmanapplication;

import java.io.IOException;
import java.util.Scanner;

public class HangmanApplication {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to hangman!\n\nI will pick a word and you will try to "
				+ "guess it character by character. \nIf you guess wrong 6 times, I win. If you can guess it less than 6 times, you win. "
				+ "\nAre you ready? I hope so because I am.");
		System.out.println();
		System.out.println("I have picked my word. Below is a picture, and below "
				+ "that is your current guess, which starts off as nothing. \nEvery time you "
				+ "guess incorrectly. I add a body part to the pictures. \nWhen there is a full "
				+ "person, you lose.");
		//Allows for multiple games
		boolean doYouWantToPlay = true;
		while(doYouWantToPlay) {
			//Setting up the game
			System.out.println("Alright! Let's play!");
			Hangman game = new Hangman();
			do {
				System.out.println();
				System.out.println(game.drawPicture());
				System.out.println();
				System.out.println(game.getFormalCurrentGuess());
				System.out.println();
				
				//get the guess
				System.out.println("Enter a character: ");
				char guess = (sc.next().toLowerCase()).charAt(0);
				System.out.println();
				
				//Check if the character is guess already
				while(game.isGuessedAlready(guess)) {
					System.out.println("Try again! Already guessed that character.");
					guess = (sc.next().toLowerCase().charAt(0));
				}
				
				if(game.playGuess(guess)) {
					System.out.println("Great guess! That character is in the word!");
				}else {
					System.out.println("Unfortunately that character is not in the word =(");
				}
				//Play the game
				
				
			}
			while(!game.gameOver());// keep playing until the game is over
		
			//keep playing
			System.out.println();
			System.out.println("Do you want to play anither game? Enter Y if you do.");
			Character response = (sc.next().toUpperCase()).charAt(0);
			doYouWantToPlay = (response == 'Y');
		}
		
	}

}
