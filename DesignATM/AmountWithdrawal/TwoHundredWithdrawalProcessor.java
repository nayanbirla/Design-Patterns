package DesignATM.AmountWithdrawal;

import DesignATM.ATM;

public class TwoHundredWithdrawalProcessor extends CashWithdrawProcessor {

    public TwoHundredWithdrawalProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){

        int required = remainingAmount/200;
        int balance = remainingAmount%200;

        if(required <= atm.getNoOfTwoHundredNotes()){
            atm.deductTwoHundredNotes(required);
        }else if(required > atm.getNoOfTwoHundredNotes()){
            balance = balance + (required-atm.getNoOfTwoHundredNotes()) * 200;
            atm.deductTwoHundredNotes(atm.getNoOfTwoHundredNotes());
        }

        if(balance != 0){
            super.withdraw(atm,balance);
        }
    }
}
