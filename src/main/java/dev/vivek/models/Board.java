package dev.vivek.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Board {
    private List<List<Cell>> board;

    public Board(int dimension){
        for(int i=0;i<dimension;i++){
            this.board = new ArrayList<>();
            for(int j=0;j<dimension;j++){
                board.get(i).add(new Cell());
            }
        }
    }

    public void display(){
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board.size();j++){
                if(board.get(i).get(j).getCellState() == CellState.EMPTY)
                    System.out.print("| |");
                else{
System.out.print("|");
                    System.out.print(board.get(i).get(j).getPlayer().getSymbol());
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
