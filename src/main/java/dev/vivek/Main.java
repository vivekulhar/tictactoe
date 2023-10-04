package dev.vivek;

import dev.vivek.controllers.GameController;
import dev.vivek.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimension of the board");
        int dimension = scanner.nextInt();
        System.out.println("Will there be a computer player? (Y/N)");
        String isBot = scanner.next();
        List<Player> players = new ArrayList<>();
        int numOfHumanPlayer = dimension - 1;
        if(isBot.equalsIgnoreCase("Y")){
            numOfHumanPlayer--;

            System.out.println("What is the name of bot");
            String name = scanner.next();
            System.out.println("What is the symbol of bot");
            String symbol = scanner.next();

            players.add(new Bot(name, symbol.charAt(0), BotDifficultyLevel.EASY));
        }
        for(int i=0;i<numOfHumanPlayer;i++){
            System.out.println("What is the name of player "+(i+1));
            String name = scanner.next();
            System.out.println("What is the symbol of player "+(i+1));
            String symbol = scanner.next();

            players.add(new Player(name, symbol.charAt(0), PlayerType.HUMAN));
        }

        // Create the game
        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension, players);

        // Start the game
        while(game.getGameStatus() == GameStatus.IN_PROGRESS){
            System.out.println("This is the current board");
            gameController.displayBoard(game);

            System.out.println("Do you want to undo the last move? (Y/N)");
            String undo = scanner.next();
            if(undo.equalsIgnoreCase("Y")){
                gameController.undo(game);

            }else{

                gameController.executeNextMove(game);
            }
        }
        System.out.println("Game has ended");
        if(game.getGameStatus() == GameStatus.ENDED){
            System.out.println("The winner is "+gameController.getWinner(game).getName());
        }

    }
}