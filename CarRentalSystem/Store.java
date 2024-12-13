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

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public String addVehicle(Vehicle vehicle)
    {
        List<Vehicle> vehicles=vehicleInventoryManagement.getVehicles();
        vehicles.add(vehicle);
        setVehicles(vehicles);
        return "Vehicle Added Successfully";
    }

    public String updateVehicle(Vehicle vehicle){
        List<Vehicle> vehicles=vehicleInventoryManagement.getVehicles();
        Vehicle vehicle1=vehicles.stream().filter((v)->v.getVehicleId()==vehicle.getVehicleId()).findFirst()
                .orElse(null);
        vehicles.remove(vehicle1);
        vehicles.add(vehicle);
        setVehicles(vehicles);
        return "Vehicle updated Successfully";
    }

    public Reservation createReservation(Vehicle vehicle,User user){
          Reservation reservation1=new Reservation();
          reservation1.setVehicle(vehicle);
          reservation1.setUser(user);
          return reservation1;
    }

    public void completeReservation(int id){

    }
}
