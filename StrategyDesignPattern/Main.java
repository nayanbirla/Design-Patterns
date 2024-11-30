package StrategyDesignPattern;

public class Main {
    
    public static void main(String[] args) {
        Vehicle vehicle=new SportVehicle();
        vehicle.drive();
        Vehicle vehicle2=new GoodsVehicle();
        vehicle2.drive();
    }
}
