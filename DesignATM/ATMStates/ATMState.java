package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.Card;
import DesignATM.TransactionType;

public abstract class ATMState {

    public void insertCard(ATM atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatedPin(ATM atm,Card card,int pin){
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(ATM atm,Card card,int withdrawlAmount){
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(ATM atm,Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard(){
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(ATM atm){
        System.out.println("OOPS!! Something went wrong");
    }
}
