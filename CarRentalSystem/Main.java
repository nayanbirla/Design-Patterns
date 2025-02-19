package CarRentalSystem;

import CarRentalSystem.Product.Car;
import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        //0. User comes
        User user = users.get(0);

        //1. user search store based on location
        Location location = new Location("",403012, "Bangalore", "Karnataka", "India");
        Store store = rentalSystem.getStore(location);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);


        //3.reserving the particular vehicle
        System.out.println(vehicles.get(0).getVehicleId());
        Reservation reservation = store.createReservation(vehicles.get(0), users.get(0));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        reservation.setBookingDate(LocalDate.parse("23-06-2024",formatter));
        reservation.setDateBookedFrom(LocalDate.parse("23-06-2024",formatter));
        reservation.setDateBookedTo(LocalDate.parse("24-07-2025",formatter));
        //4. generate the bill
        Bill bill = new Bill(reservation);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(bill,PaymentMode.ONLINE);

        //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation.reservationId);

        System.out.println(payment.paymentDetails1);
    }


    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleId(1);
        vehicle1.setVehicleType(VehicleType.CAR);
        vehicle1.setDailyRentalCost(100);
        Vehicle vehicle2 = new Car();
        vehicle2.setVehicleId(2);
        vehicle2.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.storeId=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }


}
