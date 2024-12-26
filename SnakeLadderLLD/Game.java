package SnakeLadderLLD;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game(){
        initializeGame();
    }

    private void initializeGame() {

        board = new Board(10, 5,4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("Nayan", 0);
        Player player2 = new Player("Shejal", 0);
        playersList.add(player1);
        playersList.add(player2);
    }


    public void startGame(){

        while(winner==null)
        {
            Player playerTurn=playersList.removeFirst();
            playersList.addLast(playerTurn);
            System.out.println("player turn is:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);

            int diceNumber=dice.rollDice();

            int playerPosition=playerTurn.currentPosition+diceNumber;
            playerPosition=jumpCheck(playerPosition);
            if(playerPosition<=board.cells.length * board.cells.length)
            playerTurn.currentPosition=playerPosition;

            if(playerPosition == board.cells.length * board.cells.length){
                winner = playerTurn;
            }
        }
        System.out.println("WINNER IS:" + winner.id);
    }

    int jumpCheck(int playerPosition)
    {
        if(playerPosition> board.cells.length*board.cells.length-1)
        {
            return playerPosition;
        }

        Cell cell= board.getCell(playerPosition);
        if(cell.jump!=null && cell.jump.head==playerPosition){
            String jumpBy=(cell.jump.head<cell.jump.tail)?"ladder":"snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.tail;
        }
        return playerPosition;
    }
}
