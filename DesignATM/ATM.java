package DesignATM;

import DesignATM.ATMStates.ATMState;
import DesignATM.ATMStates.IdleState;

public class ATM {
    private static ATM atmObject=new ATM(); // singleton and eager initialization

    ATMState currentATMState;

    private int atmBalance;
    int noOfFiveHundredNotes;
    int noOfTwoHundredNotes;
    int noOfHundredNotes;

    private ATM(){
    }

    public void setCurrentATMState(ATMState currentATMState){
        this.currentATMState=currentATMState;
    }

    public ATMState getCurrentATMState(){
        return currentATMState;
    }

    public static  ATM getAtmObject(){
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }

    public int getAtmBalance(){
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance,int noOfFiveHundredNotes,int noOfTwoHundredNotes,int noOfHundredNotes){
        this.atmBalance=atmBalance;
        this.noOfFiveHundredNotes=noOfFiveHundredNotes;
        this.noOfTwoHundredNotes=noOfTwoHundredNotes;
        this.noOfHundredNotes=noOfHundredNotes;
    }

    public int getNoOfFiveHundredNotes(){
        return noOfFiveHundredNotes;
    }

    public int getNoOfTwoHundredNotes(){
        return noOfTwoHundredNotes;
    }

    public int getNoOfHundredNotes(){
        return noOfHundredNotes;
    }

    public void deductAtmBalance(int amount){
        atmBalance=atmBalance-amount;
    }

    public void deductFiveHundredNotes(int number){
        noOfFiveHundredNotes-=number;
    }

    public void deductTwoHundredNotes(int number){
        noOfTwoHundredNotes-=number;
    }

    public void deductHundredNotes(int number){
        noOfHundredNotes-=number;
    }

    public void printCurrentAtmStatus(){
        System.out.println("Balance: "+atmBalance);
        System.out.println("500Notes: "+noOfFiveHundredNotes);
        System.out.println("200Notes: "+noOfTwoHundredNotes);
        System.out.println("100Notes: "+noOfHundredNotes);
    }
}
