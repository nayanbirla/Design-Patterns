package StrategyDesignPattern;

import StrategyDesignPattern.strategy.NormalDriverStrategy;

public class GoodsVehicle extends Vehicle{
    
    GoodsVehicle(){
        super(new NormalDriverStrategy());
    }
}
