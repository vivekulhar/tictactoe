package dev.vivek.strategies.gamewinningstrategy;

import dev.vivek.models.Board;
import dev.vivek.models.Cell;
import dev.vivek.models.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Player playerToMove, Cell cell);
}
