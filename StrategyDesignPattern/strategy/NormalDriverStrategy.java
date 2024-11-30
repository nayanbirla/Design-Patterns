package StrategyDesignPattern.strategy;

public class NormalDriverStrategy implements DriveStrategy {
    
    @Override
    public void drive(){
        System.out.println("Normal driver strategy");
    }
}
