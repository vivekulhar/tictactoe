package dev.vivek.models;

import dev.vivek.exceptions.InvalidGameBuildException;
import dev.vivek.strategies.gamewinningstrategy.GameWinningStrategy;
import dev.vivek.strategies.gamewinningstrategy.OrderOneWinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winner;
    private GameWinningStrategy gameWinningStrategy;
    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;
        public int getDimension() {
            return dimension;
        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public List<Player> getPlayers() {
            return players;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        private boolean isValid() throws InvalidGameBuildException{
            if(this.dimension< 3){
                throw new InvalidGameBuildException("Dimension is less than 3");
            }
            if(this.players.size()!=this.dimension-1){
                throw new InvalidGameBuildException("Issue with Number of players");
            }

            return true;
        }
        public Game build() throws InvalidGameBuildException{
            if(isValid()){
                Game game = new Game();
                game.setBoard(new Board(this.dimension));
                game.setPlayers(this.players);
                game.setGameStatus(GameStatus.IN_PROGRESS);
                game.setNextPlayerIndex(0);
                game.setMoves(new ArrayList<>());

                game.setGameWinningStrategy(new OrderOneWinningStrategy(dimension));
                return game;
            }
            return null;
        }

    }
    public static Builder builder(){
        return new Builder();
    }
    public void displayBoard(){
        this.board.display();
    }

    public void makeNextMove(){
        // Which player turn is this
        Player playerToMove = this.players.get(this.nextPlayerIndex);
        System.out.println("It is "+playerToMove.getName()+"'s turn");
        Move move = playerToMove.decideMove(this.board);

        // validate the move decided by the player
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Player "+playerToMove.getName()+" has decided to move to row "+row+" and col "+col);

        // Assumption : Move is valid
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(playerToMove);

        // Add the move to the list of moves
        this.moves.add(move);

        // Check the winner
        if(gameWinningStrategy.checkWinner(board, playerToMove,move.getCell())){
            this.setGameStatus(GameStatus.ENDED);
            this.winner = playerToMove;
        }

        // Check for DRAW

        // Go to next player
        nextPlayerIndex = (nextPlayerIndex+1)%players.size();
    }

}
