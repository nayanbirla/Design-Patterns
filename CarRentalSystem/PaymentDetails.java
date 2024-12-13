package CarRentalSystem;

import java.util.Date;

public class PaymentDetails {

    String paymentId;
    double amountPaid;
    Date dateOfPayment;
    boolean isRefundable;
    PaymentMode paymentMode;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public boolean isRefundable() {
        return isRefundable;
    }

    public void setRefundable(boolean refundable) {
        isRefundable = refundable;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "paymentId='" + paymentId + '\'' +
                ", amountPaid=" + amountPaid +
                ", dateOfPayment=" + dateOfPayment +
                ", isRefundable=" + isRefundable +
                ", paymentMode=" + paymentMode +
                '}';
    }
}
