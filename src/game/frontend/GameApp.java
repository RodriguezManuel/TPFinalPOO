package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameApp extends Application {

	static Stage window = new Stage();
	Scene firstScene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		Image image = new Image("images/candycrush.png");

		//Setting the image view
		ImageView imageView = new ImageView(image);

		//menu
		AppMenu menu = new AppMenu();

		//Creating a Group object
		BorderPane root = new BorderPane(imageView);

		root.setTop(menu);

		//Creating a scene object
		firstScene = new Scene(root);

		//display default
		window.setScene(firstScene);
		window.setTitle("Candy Crush TP POO 2019_2Q");
		window.show();
	}

	public static void restart(Class<? extends Level> clazz)
	{
		window.close();

		CandyGame game = new CandyGame(clazz);
		CandyFrame frame = new CandyFrame(game);
		Scene scene = new Scene(frame);

		window.setScene(scene);
		window.show();
	}

}
