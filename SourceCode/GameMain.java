package hangman;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameMain extends Application
{

	public void start(Stage primaryStage)
	{
		Button playButton = new Button("Play game");
		Button highscores = new Button("view highscores");
		Button quit = new Button("quit game");
		VBox MMRoot = new VBox();
		MMRoot.setAlignment(Pos.CENTER);
		MMRoot.setPadding(new Insets(5));
		MMRoot.setSpacing(10);
		MMRoot.getChildren().addAll(playButton, highscores, quit);
		Scene menuScene = new Scene(MMRoot, 640, 480);

		GridPane PGRoot = new GridPane();
		Play play = new Play();
		Label word = new Label(play.getWord());
		PGRoot.add(word, 0, 0);
		Label mistakes = new Label(play.getMistakes() + " mistakes");
		PGRoot.add(mistakes, 1, 0);
		PGRoot.add(new Label("provide a letter"), 0, 1);
		TextField letter = new TextField();
		PGRoot.add(letter, 0, 2);
		Button checkLetter = new Button("Check Letter");
		PGRoot.add(checkLetter, 1, 2);
		Button quitToMenu=new Button("Quit");
		PGRoot.add(quitToMenu, 1, 3);
		Scene playScene = new Scene(PGRoot, 640, 480);

		VBox GORoot = new VBox();
		HBox gOBox = new HBox();
		Button playAgain=new Button("Play again");
		Button backToMenu = new Button("back to main menu");
		gOBox.getChildren().addAll(playAgain,backToMenu);
		gOBox.setAlignment(Pos.CENTER);
		gOBox.setSpacing(10);
		GORoot.setAlignment(Pos.CENTER);
		GORoot.setPadding(new Insets(5));
		GORoot.setSpacing(5);
		Label message = new Label();
		GORoot.getChildren().addAll(message, gOBox);
		Scene gameOver = new Scene(GORoot, 640, 480);
		
		playAgain.setOnAction(e->{
			primaryStage.setScene(playScene);
		});
		backToMenu.setOnAction(e -> {
			primaryStage.setScene(menuScene);
		});
		checkLetter.setOnAction(e -> {
			play.play(letter.getText().toLowerCase().charAt(0));
			display(play,word,mistakes);
			if (play.getMistakes() == 6)
			{
				primaryStage.setScene(gameOver);
				message.setText("you have lost");
				play.reset();
				display(play,word,mistakes);
			} else if (!play.stillPlaying())
			{
				primaryStage.setScene(gameOver);
				message.setText("you have won");
				play.reset();
				display(play,word,mistakes);
			}
		});
		playButton.setOnAction(e -> {
			primaryStage.setScene(playScene);
		});
		quitToMenu.setOnAction(e -> 
		{
			play.reset();
			primaryStage.setScene(menuScene);
		});

		primaryStage.setScene(menuScene);
		primaryStage.show();
	}
	
	public static void display(Play p, Label l1, Label l2)
	{
		l1.setText(p.getWord());
		l2.setText(p.getMistakes() + " mistakes");
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
