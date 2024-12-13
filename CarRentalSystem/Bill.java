package CarRentalSystem;

import java.time.temporal.ChronoUnit;

public class Bill {

    Reservation reservation;
    double totalBillAmount;
    boolean isBillPaid;

    Bill(Reservation reservation)
    {
        this.reservation=reservation;
        this.totalBillAmount=computeBillAmount();
        isBillPaid=false;
    }

    private double computeBillAmount(){

         long totalDays= ChronoUnit.DAYS.between(reservation.dateBookedFrom, reservation.dateBookedTo);
         return (totalDays*reservation.getVehicle().getDailyRentalCost());
    }



}
