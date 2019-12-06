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

		primaryStage.setOnCloseRequest(event -> System.exit(0));

		Image image = new Image("images/candycrush.png");
		ImageView imageView = new ImageView(image);
		AppMenu menu = new AppMenu();
		BorderPane root = new BorderPane(imageView);
		root.setTop(menu);
		firstScene = new Scene(root);

		//display default
		window.setScene(firstScene);
		window.setTitle("Candy Crush TP POO 2019_2Q");
		window.setResizable(false);
		window.sizeToScene();
		window.show();
	}

	public static void startLevel(Class<? extends Level> clazz, ScorePanel scorePanel, AppMenu menu) {
		window.close();

		CandyGame game = new CandyGame(clazz);
		CandyFrame frame = new CandyFrame(game, scorePanel, menu);
		Scene scene = new Scene(frame);

		window.setScene(scene);
		window.sizeToScene();
		window.show();
	}

}
