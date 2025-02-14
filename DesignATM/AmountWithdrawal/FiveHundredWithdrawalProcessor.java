package DesignATM.AmountWithdrawal;

import DesignATM.ATM;

public class FiveHundredWithdrawalProcessor extends CashWithdrawProcessor{

    public FiveHundredWithdrawalProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){

        int required = remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(required);
        }else if(required > atm.getNoOfFiveHundredNotes()){
            balance = balance + (required-atm.getNoOfFiveHundredNotes()) * 500;
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
        }

        if(balance != 0){
            super.withdraw(atm,balance);
        }
    }
}
