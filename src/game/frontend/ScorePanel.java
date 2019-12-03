package game.frontend;

import game.backend.CandyGame;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public abstract class ScorePanel extends BorderPane {

	private Label scoreLabel;
	protected CandyGame game;

	protected ScorePanel() {
		setStyle("-fx-background-color: #5490ff");
		scoreLabel = new Label();
		scoreLabel.setAlignment(Pos.CENTER);
		scoreLabel.setStyle("-fx-font-size: 24");
		setCenter(scoreLabel);
	}

	protected void updateScore(String text) {
		scoreLabel.setText(text);
	}

	public void updateData(String text) {
		updateScore(text);
	}

	public void setGame(CandyGame game) {
		this.game = game;
		updateData("0");
	}

}