package com.company;


/**
 * The main simulated annealing class
 * requires 3 parameters - starting temperature, cooling rate, int numberOfIterations
 */
public class SimulatedAnnealing {

    //generate a new Travel Mode Instance
    TravelModel travel = new TravelModel(10);

    //constructor for the Simulated Annealing Class


    public void simulate(double initTemperature, double alpha, double thresholdTemp, int numOfItertations) {
        System.out.println("simulation starting...");
        travel.shuffleList();
        double t = initTemperature;
        //modelling 2 travels containing the current and the best possible sequencing
        TravelModel bestTravel = travel;  //travel container
        TravelModel currTravel = travel;  //travel container
        double bestDistance = travel.calcDistance();
        double currDistance = travel.calcDistance();


        for (int i = 0; i < numOfItertations; i++) {
            if (t > thresholdTemp) {
                currTravel.swapCities();
                currDistance = currTravel.calcDistance();

                if (currDistance < bestDistance) {
                    bestDistance = currDistance;

                } else if (Math.exp((bestDistance - currDistance) / t) < Math.random()) {
                    currTravel.revertSwap();
                }
                t *= alpha;
            } else {
                continue;
            }

            System.out.println(bestDistance);

        }


        return;
    }


}
