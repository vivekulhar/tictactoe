package dev.vivek.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private Player player;
    private int row;
    private int col;
    private CellState cellState;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }
    public Cell(Player player, int row, int col){
        this.player = player;
        this.row = row;
        this.col = col;
        this.cellState = CellState.FILLED;
    }

}
