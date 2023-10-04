package dev.vivek.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
