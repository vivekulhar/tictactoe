package dev.vivek.strategies.botplayingstrategy;

import dev.vivek.models.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Player player, Board board) {

        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().size(); j++) {
                if(board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    return new Move(player,new Cell(player,i,j,CellState.FILLED));
                }
            }
        }
        return null;
    }
}
