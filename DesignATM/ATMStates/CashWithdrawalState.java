package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.AmountWithdrawal.CashWithdrawProcessor;
import DesignATM.AmountWithdrawal.FiveHundredWithdrawalProcessor;
import DesignATM.AmountWithdrawal.HundredWithdrawalProcessor;
import DesignATM.AmountWithdrawal.TwoHundredWithdrawalProcessor;
import DesignATM.Card;

public class CashWithdrawalState extends ATMState{

    public CashWithdrawalState() {
        System.out.println("Please Enter the Withdrawal Amount");
    }

    @Override
    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest){

        if(atmObject.getAtmBalance() < withdrawalAmountRequest)
        {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        }else if (card.getBankBalance() < withdrawalAmountRequest){
            System.out.println("Insufficient fund in your Bank account");
            exit(atmObject);
        }else{
            card.deductBankBalance(withdrawalAmountRequest);
            atmObject.deductAtmBalance(withdrawalAmountRequest);

            // using chain of responsibility for thid logic, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor = new FiveHundredWithdrawalProcessor(new TwoHundredWithdrawalProcessor(new HundredWithdrawalProcessor(null)));

            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
            exit(atmObject);
        }
    }

    @Override
    public void exit(ATM atmObject){
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
