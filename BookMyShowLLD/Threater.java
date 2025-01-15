package BookMyShowLLD;

import java.util.List;

public class Threater {
    Integer id;
    String address;
    City city;
    List<Screen> screenList;
    List<Show> showsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Show> getShowsList() {
        return showsList;
    }

    public void setShowsList(List<Show> showsList) {
        this.showsList = showsList;
    }
}
