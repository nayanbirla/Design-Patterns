package ObservableDesignPattern;

import javax.management.Notification;

import ObservableDesignPattern.Observable.IphoneObservableImpl;
import ObservableDesignPattern.Observable.StockObservable;
import ObservableDesignPattern.Observer.NotificationAlertObserver;
import ObservableDesignPattern.Observer.EmailNotificationAlertObserver;
import ObservableDesignPattern.Observer.MobileNotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        
        StockObservable iphonStockObservable=new IphoneObservableImpl();

        NotificationAlertObserver alertObserver=new EmailNotificationAlertObserver("nayanbirla9893@gmail.com",iphonStockObservable);
        NotificationAlertObserver alertObserver2=new EmailNotificationAlertObserver("nayanbirla2@gmail.com",iphonStockObservable);
        NotificationAlertObserver alertObserver3=new MobileNotificationAlertObserver("1234567890",iphonStockObservable);

        iphonStockObservable.add(alertObserver);
        iphonStockObservable.add(alertObserver2);
        iphonStockObservable.add(alertObserver3);

        iphonStockObservable.setStockCount(10);
        iphonStockObservable.setStockCount(-10);
        iphonStockObservable.setStockCount(10);

    }
}
