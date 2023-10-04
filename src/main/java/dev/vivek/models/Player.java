package dev.vivek.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private char symbol;
    private String name;
    private PlayerType type;
}
