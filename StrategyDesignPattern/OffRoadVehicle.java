package StrategyDesignPattern;

import StrategyDesignPattern.strategy.SportDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    
    OffRoadVehicle(){
        super(new SportDriveStrategy());
    }
}
