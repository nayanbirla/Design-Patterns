package ElevatorDesign;

public class ElevatorCar {

    int id;
    ElevatorDisplay elevatorDisplay;
    InternalButton internalButton;
    ElevatorState elevatorState;
    int currentFloor;
    Direction elevatorDirection;
    ElevatorDoors elevatorDoors;

    public ElevatorCar(){
        elevatorDisplay=new ElevatorDisplay();
        internalButton=new InternalButton();
        elevatorState=ElevatorState.IDLE;
        currentFloor=0;
        elevatorDirection=Direction.UP;
        elevatorDoors=new ElevatorDoors();
    }

    public void showDisplay(){
        elevatorDisplay.showDisplay();
    }

    public void pressButton(int destination){
        internalButton.pressButton(destination,this);
    }

    public void setElevatorDisplay(){
        this.elevatorDisplay.setDisplay(currentFloor,elevatorDirection);
    }

    boolean moveElevator(Direction dir,int destinationFloor){
        int startFloor=currentFloor;
        if(dir==Direction.UP)
        {
            for(int i=startFloor;i<=destinationFloor;i++)
            {
                this.currentFloor=startFloor;
                setElevatorDisplay();
                showDisplay();
                if(i==destinationFloor)
                    return true;
            }
        }
        if(dir==Direction.DOWN)
        {
            for(int i=startFloor;i>=destinationFloor;i--)
            {
                this.currentFloor=currentFloor;
                setElevatorDisplay();
                showDisplay();
            }
        }
        return false;
    }



}
