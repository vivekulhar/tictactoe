package dev.vivek.strategies.gamewinningstrategy;

import dev.vivek.models.Board;
import dev.vivek.models.Cell;
import dev.vivek.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements GameWinningStrategy{
    private List<HashMap<Character,Integer>> rowSymbolCount = new ArrayList<>();
    private List<HashMap<Character,Integer>> columnSymbolCount = new ArrayList<>();
    private HashMap<Character,Integer> topRightDiagonalSymbolCount;
    private HashMap<Character,Integer> topLeftDiagonalSymbolCount;

    public OrderOneWinningStrategy(int dimension){
        for(int i=0;i<dimension;i++){
            rowSymbolCount.add(new HashMap<>());
            columnSymbolCount.add(new HashMap<>());
        }
        topRightDiagonalSymbolCount = new HashMap<>();
        topLeftDiagonalSymbolCount = new HashMap<>();
    }
    private boolean isCellOnTopRightDiagonal(int row, int col, int dimension){
        return row + col == dimension - 1;
    }
    private boolean isCellOnTopLeftDiagonal(int row, int col){
        return row == col;
    }

    @Override
    public boolean checkWinner(Board board, Player playerToMove, Cell cell) {

        char symbol = playerToMove.getSymbol();
        int row = cell.getRow();
        int col = cell.getCol();
        int dimension = board.getBoard().size();

        if(!rowSymbolCount.get(row).containsKey(symbol)) {
            rowSymbolCount.get(row).put(symbol, 0);
        }
        rowSymbolCount.get(row).put(symbol, rowSymbolCount.get(row).get(symbol)+1);
        if (!columnSymbolCount.get(col).containsKey(symbol)) {
            columnSymbolCount.get(col).put(symbol, 0);
        }
        columnSymbolCount.get(col).put(symbol, columnSymbolCount.get(col).get(symbol)+1);
        if(isCellOnTopRightDiagonal(row, col, dimension)){
            if(!topRightDiagonalSymbolCount.containsKey(symbol)){
                topRightDiagonalSymbolCount.put(symbol, 0);
            }
            topRightDiagonalSymbolCount.put(symbol, topRightDiagonalSymbolCount.get(symbol)+1);
        }
        if(isCellOnTopLeftDiagonal(row, col)){
            if(!topLeftDiagonalSymbolCount.containsKey(symbol)){
                topLeftDiagonalSymbolCount.put(symbol, 0);
            }
            topLeftDiagonalSymbolCount.put(symbol, topLeftDiagonalSymbolCount.get(symbol)+1);
        }
        if(rowSymbolCount.get(row).get(symbol) == dimension || columnSymbolCount.get(col).get(symbol) == dimension){
            return true;
        }
        if(isCellOnTopRightDiagonal(row, col, dimension) && topRightDiagonalSymbolCount.get(symbol) == dimension){
            return true;
        }
        if (isCellOnTopLeftDiagonal(row, col) && topLeftDiagonalSymbolCount.get(symbol) == dimension) {
            return true;
        }
        return false;

    }
}
