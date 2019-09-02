import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class FundsTransfer extends Thread {

    @Override
    public void run()
    {
        Double amountMin = 0.0;
        Double amountMax = 1000.0;
        Integer accountIdMin = 0;
        Integer accountIdMax = 5;
        Random rn = new Random();

        while(true)
        {
            String accountId1 = "accountId" + Integer.toString( accountIdMin + rn.nextInt(accountIdMax - accountIdMin + 1) );
            String accountId2 = "accountId" + Integer.toString( accountIdMin + rn.nextInt(accountIdMax - accountIdMin + 1) );
            Double amount = amountMin + ( amountMax - amountMin ) * rn.nextDouble();

            String queryUrl = "http://localhost:8000/transfer?accountId1=" + accountId1 +"&accountId2=" + accountId2+ "&amount="+Double.toString(amount);
            System.out.println("firing "+queryUrl);

            try {
                URL obj = new URL(queryUrl);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                // optional default is GET
                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'GET' request to URL : " + queryUrl);
                System.out.println("Response Code : " + responseCode);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //print result
                System.out.println(response.toString());

                Thread.sleep((long) (Math.random()*3000));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
