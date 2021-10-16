package org.lxgames.myPaint;

import org.lxgames.myPaint.utils.KeyboardController;
import org.lxgames.myPaint.utils.MouseController;

public class Main {

    public static void main(String[] args) {

        MapEditor mapEditor = new MapEditor(20, 20);
        new KeyboardController(mapEditor);

        new MouseController(mapEditor);
    }
}
