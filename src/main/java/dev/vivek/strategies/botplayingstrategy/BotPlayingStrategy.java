package dev.vivek.strategies.botplayingstrategy;

import dev.vivek.models.*;

public interface BotPlayingStrategy {
    Move makeMove(Player player, Board board);
}
