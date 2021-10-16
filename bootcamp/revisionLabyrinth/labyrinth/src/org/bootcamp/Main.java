package org.bootcamp;


import org.bootcamp.utils.KeyboardController;

public class Main {
    public static void main(String[] args) {
       Labyrinth maze = new Labyrinth();
       KeyboardController controller = new KeyboardController(maze);
       controller.init();
    }
}
