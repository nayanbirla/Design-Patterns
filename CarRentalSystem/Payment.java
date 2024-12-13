package CarRentalSystem;

import java.util.Date;
import java.util.UUID;

public class Payment {

    PaymentDetails paymentDetails1;

    public void payBill(Bill bill,PaymentMode paymentMode)
    {
        //do payment processing and update the bill status;
        PaymentDetails paymentDetails=new PaymentDetails();
        UUID uuid = UUID.randomUUID();
        paymentDetails.setPaymentId(uuid.toString());
        paymentDetails.setAmountPaid(bill.totalBillAmount);
        paymentDetails.setDateOfPayment(new Date());
        paymentDetails.setPaymentMode(paymentMode);
        bill.isBillPaid=true;
        this.paymentDetails1=paymentDetails;
    }
}
