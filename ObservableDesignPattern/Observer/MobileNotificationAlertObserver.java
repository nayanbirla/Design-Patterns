package ObservableDesignPattern.Observer;

import ObservableDesignPattern.Observable.StockObservable;

public class MobileNotificationAlertObserver implements NotificationAlertObserver{
    
    String mobileNumber;
    StockObservable observable;

    public MobileNotificationAlertObserver(String mobileNumber,StockObservable observable)
    {
        this.mobileNumber=mobileNumber;
        this.observable=observable;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        sendSms(mobileNumber,"Product is available hurry up");
    }

    public void sendSms(String mobileNumber,String msg)
    {
       System.out.println("sms send to:"+ mobileNumber);
    }
}
