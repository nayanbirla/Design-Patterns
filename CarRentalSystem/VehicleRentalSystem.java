package CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {

    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> storeList,List<User> userList)
    {
        this.storeList=storeList;
        this.userList=userList;
    }

    public Store getStore(Location location){

        //based on location, we will filter out the Store from storeList.
        return storeList.get(0);
    }



    //addUsers
    public String addUsers(User user){
        userList.add(user);
        return "User Added Successfully";
    }

    //remove users
    public String removeUser(User user)
    {
        userList.remove(user);
        return "User deleted successfully";
    }

    //add stores
    public String addStore(Store store)
    {
        storeList.add(store);
        return "Add store successfully";
    }

    //remove stores
    public String removeStore(Store store){
        storeList.remove(store);
        return "Remove Store Successfully";
    }


}
