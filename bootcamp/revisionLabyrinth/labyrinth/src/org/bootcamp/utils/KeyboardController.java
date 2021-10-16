package org.bootcamp.utils;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.bootcamp.Direction;
import org.bootcamp.Labyrinth;

public class KeyboardController implements KeyboardHandler {

    private Labyrinth labyrinth;

    public KeyboardController(Labyrinth labyrinth){
        this.labyrinth = labyrinth;
    }

    public void init(){
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent[] events = new KeyboardEvent[4];

        for (int i = 0; i < events.length; i++) {
            events[i] = new KeyboardEvent();
        }

        events[0].setKey(KeyboardEvent.KEY_W);
        events[0].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        events[1].setKey(KeyboardEvent.KEY_S);
        events[1].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        events[2].setKey(KeyboardEvent.KEY_A);
        events[2].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        events[3].setKey(KeyboardEvent.KEY_D);
        events[3].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
;
        for (KeyboardEvent event:events) {
            keyboard.addEventListener(event);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_W:
                labyrinth.move(Direction.UP);
                break;
            case KeyboardEvent.KEY_S:
                labyrinth.move(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_A:
                labyrinth.move(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_D:
                labyrinth.move(Direction.RIGHT);
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
