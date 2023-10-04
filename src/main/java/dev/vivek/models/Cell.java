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
}
