package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {

    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservation=new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return vehicleInventoryManagement.getVehicles();
    }

    //addVehicles, update vehicles, use inventory management to update those.

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle,User user){
          return new Reservation();
    }

    public void completeReservation(int id){

    }
}
