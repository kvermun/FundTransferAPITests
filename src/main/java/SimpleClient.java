
public class SimpleClient {

    public static void main(String[] args) throws Exception {

        Integer accountIdMin = 0;
        Integer accountIdMax = 5;
        Double minBalance = 0.0;
        Double maxBalance = 1000000.0;
        Double minTransferAmount = 0.0;
        Double maxTransferAmount = 1000000.0;

        AccountRegistration registrationThread = new AccountRegistration(accountIdMin,accountIdMax,minBalance,maxBalance);
        FundsTransfer transferThread1 = new FundsTransfer(accountIdMin, accountIdMax, minTransferAmount, maxTransferAmount);
        FundsTransfer transferThread2 = new FundsTransfer(accountIdMin, accountIdMax, minTransferAmount, maxTransferAmount);

        registrationThread.start();
        transferThread1.start();
        transferThread2.start();


    }
}
