package game.frontend;

import game.backend.CandyGame;
import game.backend.element.Candy;
import game.backend.level.Level1;
import game.backend.level.Level3;
import game.backend.level.TimeLevel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class L1ScorePanel extends ScorePanel {

    private final String REQUIREDSCORETEXT= "Required score: ";
    private final String REMAININGMOVESTEXT= "Remaining moves: ";
    private Label remainingMovesLabel;
    private Label requiredScoreLabel;

    public L1ScorePanel()
    {
        super();
        setStyle("-fx-background-color: #5490ff");
        remainingMovesLabel = new Label();
        remainingMovesLabel.setAlignment(Pos.TOP_LEFT);
        remainingMovesLabel.setStyle("-fx-font-size: 24");
        setLeft(remainingMovesLabel);
        requiredScoreLabel=new Label();
        requiredScoreLabel.setAlignment(Pos.TOP_RIGHT);
        requiredScoreLabel.setStyle("-fx-font-size: 24");
        setRight(requiredScoreLabel);
    }

    @Override
    public void setGame(CandyGame game)
    {
        super.setGame(game);
        requiredScoreLabel.setText(REQUIREDSCORETEXT+((Level1)game.getGrid()).getRequiredScore() );
        updateRemainingMoves();
    }

    private void updateRemainingMoves()
    {
        remainingMovesLabel.setText(REMAININGMOVESTEXT+getRemainingMoves());
    }

    private long getRemainingMoves()
    {
        long maxMoves= ((Level1)game.getGrid()).getMaxMoves();
        long currentMoves= ((Level1)game.getGrid()).state().getMoves();
        return  maxMoves - currentMoves;
    }

    @Override
    public void updateData(String text)
    {
       super.updateData(text);
       updateRemainingMoves();
       if(game.isFinished())
       {
           remainingMovesLabel.setText("");
           requiredScoreLabel.setText("");
       }
    }
}
