package dev.vivek.models;

import dev.vivek.exceptions.InvalidGameBuildException;
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

}
