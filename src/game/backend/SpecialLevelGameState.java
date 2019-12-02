package game.backend;

import game.backend.element.SpecialCandy;

public abstract class SpecialLevelGameState extends GameState {

    private int candyGoal;
    private int countdown;
    private int specialsLeft = candyGoal;
    private int spawnedSpecials = 0;

    protected SpecialLevelGameState( int candyGoal ){
        this.candyGoal = candyGoal;
    }

    protected void setCountdown( int value ){
        countdown = value;
    };

    public int getSpawnedSpecials(){
        return spawnedSpecials;
    }

    public void explodedSpecial( SpecialCandy explodedCandy ){
        specialsLeft--;
    };

    @Override
    public boolean gameOver(){
        return playerWon() || countdown == 0;
    }

    @Override
    public boolean playerWon(){
        return specialsLeft == 0;
    }

}
