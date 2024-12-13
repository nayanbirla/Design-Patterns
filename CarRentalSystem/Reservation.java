package CarRentalSystem;

import CarRentalSystem.Product.Vehicle;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Reservation {

    int reservationId;
    User user;
    Vehicle vehicle;
    LocalDate bookingDate;
    LocalDate dateBookedFrom;
    LocalDate dateBookedTo;
    Location pickUpLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;

    public int createReserve(User user, Vehicle vehicle){

        //generate new id
        reservationId = 12232;
        this.user=user;
        this.vehicle=vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
        return reservationId;
    }

    // CRUD operations


    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getDateBookedFrom() {
        return dateBookedFrom;
    }

    public void setDateBookedFrom(LocalDate dateBookedFrom) {
        this.dateBookedFrom = dateBookedFrom;
    }

    public LocalDate getDateBookedTo() {
        return dateBookedTo;
    }

    public void setDateBookedTo(LocalDate dateBookedTo) {
        this.dateBookedTo = dateBookedTo;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
