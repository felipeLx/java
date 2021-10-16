package org.academiadecodigo.arabiannights.genie;

/**
 * Demon capable of providing infinite wishes until used to recharge a MagicLamp
 */
public class RecyclableDemon extends Genie {

    // Set to true if already used to recharge a MagicLamp
    private boolean recycled = false;

    /**
     * Calls the parent constructor
     * @see Genie#Genie(int)
     */
    public RecyclableDemon(int wishLimit) {
        super(wishLimit);
    }

    public boolean isRecycled() {
        return recycled;
    }

    public void recycle() {
        recycled = false;
    }

    /**
     * @see Genie#hasWishesLeft()
     */
    @Override
    public boolean hasWishesLeft() {
        return !recycled;
    }

    /**
     * @see Genie#toString()
     */
    @Override
    public String toString() {

        return recycled ? "Demon has been recycled" : "Recyclable demon has granted " + getGrantedWishes() + " wishes.";
    }
}
