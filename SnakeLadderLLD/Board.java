package SnakeLadderLLD;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell cells[][];

    public Board(int boardSize,int snakes,int ladder)
    {
        initializeCells(boardSize);
       addSnakeLadder(cells,snakes,ladder);
       printBoard();
    }

    public void initializeCells(int boardSize){
        cells = new Cell[boardSize][boardSize];

        for(int i=0;i<boardSize;i++) {
            for(int j=0; j<boardSize;j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }

    }

    public void addSnakeLadder(Cell cells[][],int snakes,int ladder){

        while(snakes>0)
        {
            int snakeHead= ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail= ThreadLocalRandom.current().nextInt(1,snakeHead-1);

            if(getCell(snakeHead).jump!=null) continue;

            Jump snakeObj=new Jump(snakeHead,snakeTail);

            Cell cell=getCell(snakeHead);
            cell.jump=snakeObj;

            snakes--;
        }

        while(ladder>0)
        {
            int ladderStart=ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd=ThreadLocalRandom.current().nextInt(ladderStart+1,cells.length*cells.length-1);

            if(getCell(ladderStart).jump!=null) continue;

            Jump ladderObj=new Jump(ladderStart,ladderEnd);

            Cell cell=getCell(ladderStart);
            cell.jump=ladderObj;

            ladder--;

        }
    }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];
    }


    public void printBoard(){

        for(int i=0;i<cells.length;i++)
        {
            for(int j=0;j<cells.length;j++)
            {
                if(cells[i][j].jump==null)
                {
                    System.out.print("Empt ");
                }else{
                    System.out.print("Jump ");
                }
            }
            System.out.println();
        }
    }


}
