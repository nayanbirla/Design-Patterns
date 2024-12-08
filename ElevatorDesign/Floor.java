package ElevatorDesign;

public class Floor {

    int floorNumber;
    ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber)
    {
        this.floorNumber=floorNumber;
        externalDispatcher=new ExternalDispatcher();
    }

    public void pressButton(Direction direction)
    {
        externalDispatcher.submitExternaRequest(floorNumber,direction);
    }
}
