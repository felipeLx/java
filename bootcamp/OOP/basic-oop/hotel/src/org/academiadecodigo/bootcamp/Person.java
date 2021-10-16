package org.academiadecodigo.bootcamp;

public class Person {

    private String name;
    private Hotel hotel;
    private int roomId = -1; // -1 means no room ID

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean checkIn() {

        if (hotel == null || roomId != -1) {
            return false;
        }

        roomId = hotel.checkIn();
        if (roomId == -1) {
            return false;
        }

        return true;

    }

    public boolean checkOut() {

        if (hotel == null || roomId == -1) {
            return false;
        }

        hotel.checkOut(roomId);
        roomId = -1;
        return true;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hotel=" + (hotel == null ? "" : hotel) +
                ", roomId=" + (roomId == -1 ? "" : roomId) +
                '}';
    }
}
