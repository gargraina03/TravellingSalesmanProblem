package com.company;


import java.util.ArrayList;

/**
 * The main simulated annealing class
 * requires 3 parameters - starting temperature, cooling rate, int numberOfIterations
 */
public class SimulatedAnnealing {

    //generate a new Travel Mode Instance
    TravelModel travel = new TravelModel(10);

    //constructor for the Simulated Annealing Class


    public ArrayList<CityNode> simulate(double initTemperature, double alpha, double thresholdTemp, int numOfItertations) {
        travel.shuffleList();
        double optimisedDistance = 0.0;
        ArrayList<CityNode> optSequence = new ArrayList<>();
        for (int i = 0; i < numOfItertations; i++) {

        }


        return optSequence;


    }


}
