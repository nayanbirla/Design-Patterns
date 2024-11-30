package ObservableDesignPattern.Observer;

import ObservableDesignPattern.Observable.StockObservable;

public class EmailNotificationAlertObserver implements NotificationAlertObserver {
 
    String email;
    StockObservable observable;
    
    public EmailNotificationAlertObserver(String email,StockObservable observable)
    {
        this.email=email;
        this.observable=observable;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        sendMail(email,"Product is in stock hurry up");
    }

    private void sendMail(String emailId,String msg)
    {
        System.out.println("mail send to:"+ emailId);
    }
}
