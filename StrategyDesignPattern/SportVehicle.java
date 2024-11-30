package StrategyDesignPattern;

import StrategyDesignPattern.strategy.SportDriveStrategy;

public class SportVehicle extends Vehicle{
    
    public SportVehicle(){
        super(new SportDriveStrategy());
    }
}
