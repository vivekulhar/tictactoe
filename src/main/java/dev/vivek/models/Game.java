package dev.vivek.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
}
