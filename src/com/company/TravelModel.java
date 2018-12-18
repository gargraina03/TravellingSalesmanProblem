package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for modelling travel between cities
 */

public class TravelModel {
    private List<CityNode> newTravel = new ArrayList<>();
    private List<CityNode> previousTravel = new ArrayList<>();

    //constructor for the Travel Model - generates a random list of cities with user defined number of destinations
    public TravelModel(int numOfCities) {
        for (int i = 0; i < numOfCities; i++) {
            int randomX = (int) (Math.random() * 1000);  //generates random coordinates on the map in the range of 1 to 1000
            int randomY = (int) (Math.random() * 1000);
            newTravel.add(new CityNode(randomX, randomY));
        }
    }


    //randomise the list
    public void shuffleList() {
        if (newTravel.isEmpty()) {
            //generate a new Travel List
            new TravelModel(20);
        } else {
            //else shuffle the generated list
            Collections.shuffle(newTravel);
        }
    }


    public void swapCities() {
        int i = (int) (Math.random() * newTravel.size()) - 1;
        int j = (int) (Math.random() * newTravel.size()) - 1;
        swapCityNodes(i, j);
    }

    //swap cities at 2 random indices
    private void swapCityNodes(int i, int j) {
        previousTravel = newTravel;  //our current list becomes the previous list
        CityNode cityAti = previousTravel.get(i);
        CityNode cityAtj = previousTravel.get(j);
        newTravel.set(i, cityAtj);
        newTravel.set(j, cityAti);
    }


    //revert the swap if the new distance is greater than the previous one
    public void revertSwap() {
        newTravel = previousTravel;
    }

    //function to calculate and sum the distance between the cities in one iteration order
    public int calcDistance() {
        //working on the newTravel List
        int sumDistance = 0;
        for (int i = 0; i < newTravel.size(); i++) {
            CityNode startCity = newTravel.get(i);
            CityNode destCity;
            if (i + 1 < newTravel.size()) {
                destCity = newTravel.get(i + 1);
            } else {
                //if the start city becomes the last index of the newTravel list
                destCity = newTravel.get(0);
            }
            sumDistance += startCity.distanceTo(destCity);
        }

        return sumDistance;
    }
}
