package ObservableDesignPattern.Observable;

import java.util.ArrayList;
import java.util.List;

import ObservableDesignPattern.Observer.NotificationAlertObserver;

public class IphoneObservableImpl implements StockObservable {
    
    public List<NotificationAlertObserver> observerList=new ArrayList<>();
    public int stockCount=0;
 
    @Override
    public void add(NotificationAlertObserver observer) {
        // TODO Auto-generated method stub
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        // TODO Auto-generated method stub
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        // TODO Auto-generated method stub
        for(NotificationAlertObserver alertObserver: observerList)
        {
            alertObserver.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        // TODO Auto-generated method stub
        if(stockCount==0)
        {
            notifySubscribers();
        }
        stockCount=stockCount+newStockAdded;
    }
    public int getStockCount(){
        return stockCount;
    }

}
