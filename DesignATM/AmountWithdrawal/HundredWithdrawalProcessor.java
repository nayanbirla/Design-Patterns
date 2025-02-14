package DesignATM.AmountWithdrawal;

import DesignATM.ATM;

public class HundredWithdrawalProcessor extends CashWithdrawProcessor {

    public HundredWithdrawalProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){

        int required = remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getNoOfHundredNotes()){
            atm.deductHundredNotes(required);
        }else if(required > atm.getNoOfHundredNotes()){
            balance = balance + (required-atm.getNoOfHundredNotes()) * 100;
            atm.deductHundredNotes(atm.getNoOfHundredNotes());
        }

        if(balance != 0){
            System.out.println("Something went wrong");
        }
    }
}
