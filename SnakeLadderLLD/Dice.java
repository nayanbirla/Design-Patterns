package SnakeLadderLLD;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min=1;
    int max=6;

    public Dice(int diceCount)
    {
        this.diceCount=diceCount;
    }

    public int rollDice(){
        return ThreadLocalRandom.current().nextInt(min,max);
    }
}
