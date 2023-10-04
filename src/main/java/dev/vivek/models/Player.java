package dev.vivek.models;

import lombok.Getter;
import lombok.Setter;

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
}
