
public class SimpleClient {

    public static void main(String[] args) throws Exception {

        AccountRegistration registrationThread = new AccountRegistration();
        FundsTransfer transferThread = new FundsTransfer();

        registrationThread.start();
        transferThread.start();


    }
}
