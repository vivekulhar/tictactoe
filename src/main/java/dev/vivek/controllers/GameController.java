package dev.vivek.controllers;

import dev.vivek.models.Game;
import dev.vivek.models.GameStatus;
import dev.vivek.models.Player;

import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> players){
        try{
            return Game.getBuilder()
                    .setPlayers(players)
                    .setDimension(dimension)
                    .build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void undo(Game game){

    }
    public void displayBoard(Game game){
        game.displayBoard();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void executeNextMove(Game game){
//        game.executeNextMove();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
}
