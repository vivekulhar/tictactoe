package dev.vivek.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private char symbol;
    private String name;
    private PlayerType type;

    public Player(String name, char symbol, PlayerType type){
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }

    public Move decideMove(Board board){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row and column");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Move(this, new Cell(this,row, col, CellState.FILLED));
    }
}
