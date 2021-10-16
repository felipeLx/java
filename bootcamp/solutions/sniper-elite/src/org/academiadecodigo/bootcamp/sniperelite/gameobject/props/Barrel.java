package org.academiadecodigo.bootcamp.sniperelite.gameobject.props;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.Destroyable;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObject;

/**
 * A barrel game object, capable of being shot at
 */
public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;

    public Barrel() {

        int index = (int) (Math.random() * (BarrelType.values().length + 1));
        barrelType = BarrelType.values()[index];

    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * @see Destroyable#hit(int)
     */
    @Override
    public void hit(int damage) {

        currentDamage++;

        if(currentDamage >= barrelType.getMaxDamage()) {
            destroyed = true;
        }

    }

    /**
     * @see GameObject#getMessage()
     */
    @Override
    public String getMessage() {
        return "Barrel found. Let's blow it!";
    }
}
