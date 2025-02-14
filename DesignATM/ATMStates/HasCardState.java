package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.Card;

public class HasCardState extends ATMState{

    public HasCardState(){
        System.out.println("enter your card pin number");
    }

    @Override
    public void authenticatedPin(ATM atm, Card card,int pin){
        boolean isCorrectPinEnterted =card.isCorrectPINEntered(pin);

        if(isCorrectPinEnterted){
            atm.setCurrentATMState(new SelectOperationState());
        }else{
            System.out.println("Invalid PIN Number");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect you card");
    }
}
