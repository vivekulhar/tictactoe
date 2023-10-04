package dev.vivek.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
}
