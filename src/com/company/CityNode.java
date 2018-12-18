package com.company;

/**
 * This class contains the x and y coordinates of each Node on the graph*/

public class CityNode {
    //x and y coordinates
    private int x;
    private int y;

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }




    //constructor
    public CityNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //function to calculate distance to a given city node
    public double distanceTo(CityNode city){
        int x = Math.abs(this.getX()-city.getX());
        int y = Math.abs(this.getY()-city.getY());
        double x_2 = Math.pow(x,2);
        double y_2 = Math.pow(y,2);
        return (Math.sqrt(x_2+y_2));
    }





}
