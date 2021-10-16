package org.bootcamp;

import org.bootcamp.cells.Player;

public class Labyrinth {

    Player player;
    Grid grid;


    public Labyrinth() {
        player = new Player();
        grid = new Grid();
    }


    public void move(Direction direction) {
        if (grid.isValidMove(player.getRow(), player.getCol(), direction)){
            player.move(direction);
        }
    }
}
