package org.lxgames.myPaint.utils;


import org.academiadecodigo.simplegraphics.mouse.*;
import org.lxgames.myPaint.MapEditor;
import org.lxgames.myPaint.grid.Cursor;


public class MouseController implements MouseHandler {

    private MapEditor mapEditor;
    MouseHandler handler;


    public MouseController(MapEditor mapEditor) {

        this.mapEditor = mapEditor;
        initMouse();
    }

    private void initMouse() {

        Mouse mouse = new Mouse(this);
        MouseEvent event = new MouseEvent(10,10,MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (MouseEventType.MOUSE_CLICKED == null) {
                mapEditor.moveCursor(Cursor.Direction.RIGHT);

            //case KeyboardEvent.KEY_LEFT:
                mapEditor.moveCursor(Cursor.Direction.LEFT);

    }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
