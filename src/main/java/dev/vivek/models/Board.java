package dev.vivek.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Board {
    private List<List<Cell>> board;
}
