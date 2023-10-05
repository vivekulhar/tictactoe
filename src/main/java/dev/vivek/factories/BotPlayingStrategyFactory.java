package dev.vivek.factories;

import dev.vivek.models.BotDifficultyLevel;
import dev.vivek.strategies.botplayingstrategy.BotPlayingStrategy;
import dev.vivek.strategies.botplayingstrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new RandomBotPlayingStrategy();
        }
        return null;
    }
}
