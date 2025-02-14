package DesignATM.AmountWithdrawal;

import DesignATM.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawalProcesor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        this.nextCashWithdrawalProcesor = cashWithdrawProcessor;
    }

    public void withdraw(ATM atm,int remainingAmount){

        if(nextCashWithdrawalProcesor != null){
            nextCashWithdrawalProcesor.withdraw(atm,remainingAmount);
        }
    }
}
