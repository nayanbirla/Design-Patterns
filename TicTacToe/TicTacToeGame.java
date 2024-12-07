package TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import TicTacToe.Model.Board;
import TicTacToe.Model.PieceType;
import TicTacToe.Model.Player;
import TicTacToe.Model.PlayingPiece;
import TicTacToe.Model.PlayingPieceO;
import TicTacToe.Model.PlayingPieceX;
import TicTacToe.Utils.Pair;

public class TicTacToeGame {
    
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame()
    {
        initializeGame();
    }

    public void initializeGame(){
        players=new LinkedList<>();
        PlayingPieceX crossPiece=new PlayingPieceX();
        Player player1=new Player("Nayan", crossPiece);

        PlayingPieceO noughtPiece=new PlayingPieceO();
        Player player2=new Player("Shejal", noughtPiece);
        players.add(player1);
        players.add(player2);
        gameBoard=new Board(3);
    }

    public String startGame(){
        boolean noWinner=true;
        
        while(noWinner){
        Player playerTurn=players.removeFirst();

        gameBoard.printBoard();
        List<Pair<Integer,Integer>> freeSpaces = gameBoard.getFreeCells();
        if(freeSpaces.isEmpty())
        {
            noWinner=false;
            continue;
        }

        //read the user input
        System.out.println("Player:" + playerTurn.name + " Enter row,column: ");
        Scanner inputScanner=new Scanner(System.in);
        String s=inputScanner.nextLine();
        String[] values=s.split(",");
        int inputRow=Integer.valueOf(values[0]);
        int inputColumn=Integer.valueOf(values[1]);

        boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
        if(!pieceAddedSuccessfully)
        {
            System.out.println("Incorrect possition chosen, try again");
            players.addFirst(playerTurn);
            continue;
        }
        players.addLast(playerTurn);

        boolean winner= isThereWinner(inputRow,inputColumn,playerTurn.playingPiece.pieceType);

        if(winner)
        {
            gameBoard.printBoard();
            return playerTurn.name;
        }
      }
      return "tie";
  }

  public boolean isThereWinner(int row,int col,PieceType pieceType)
  {
    boolean rowMatch=true;
    boolean colMatch=true;
    boolean diagonalMatch=true;
    boolean antiDiagonalMatch=true;

    //need to check in row
    for(int i=0;i<gameBoard.size;i++)
    {
        if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType!=pieceType)
        {
            rowMatch=false;
            break;
        }
    }

    //need to check in column
    for(int i=0;i<gameBoard.size;i++)
    {
        if(gameBoard.board[i][col]==null || gameBoard.board[i][col].pieceType!=pieceType)
        {
                      colMatch=false;
                      break;
        }
    }

    //need to check diagonal
    for(int i=0,j=0;i<gameBoard.size;i++,j++){
        if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType)
        {
            diagonalMatch=false;
            break;
        }
    }

    //need to check anti-diagonals
    for(int i=0,j=gameBoard.size-1;i<gameBoard.size;i++,j--)
    {
        if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType)
        {
            antiDiagonalMatch=false;
            break;
        }
    }

    return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;

  }
}
