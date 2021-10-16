package org.academiadecodigo.bootcamp;

public class Hotel {

    private String name;
    private Room[] rooms;

    public Hotel(String name, int numRooms) {
        this.name = name;
        rooms = new Room[numRooms];
    }

    /**
     * returns the room number if available or -1 if no more rooms are available
     */
    public int checkIn() {

        for (int i = 0; i < rooms.length ; i++) {

            if (rooms[i] == null) {
                rooms[i] = new Room(); // this technique is called lazy instantiation
            }

            if (rooms[i].isAvailable()) {
                rooms[i].setAvailable(false);
                return i;
            }

        }

        // there are better ways to do this in Java
        // we will learn these latter on!
        return -1;
    }

    public void checkOut(int roomId) {
        if (rooms[roomId] != null) {
            rooms[roomId].setAvailable(true);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms.length +
                '}';
    }
}
