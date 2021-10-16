package org.academiadecodigo.bootcamp.sniperelite.gameobject.weapons;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.Destroyable;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy.Enemy;

/**
 * A sniper rifle used to kill enemies
 */
public class SniperRifle {

    public static final double HIT_PROBABILITY = 0.7;

    private int shootsFired;
    private int bulletDamage;

    /**
     * Constructs a snipper rifle
     * @param bulletDamage the amount of damaged caused by each shot
     */
    public SniperRifle(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public int getShootsFired() {
        return shootsFired;
    }

    /**
     * Take a shoot at an enemy
     * @param target the enemy to shoot
     */
    public void shoot(Destroyable target) {

        shootsFired++;

        if(Math.random() < HIT_PROBABILITY) {

            target.hit(bulletDamage);
            System.out.println("It's a hit!");

        } else {
            System.out.println("It's a miss!");
        }

    }
}
