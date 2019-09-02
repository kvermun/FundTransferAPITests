import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class AccountRegistration extends Thread {

    @Override
    public void run(){

        Integer accountIdMin = 0;
        Integer accountIdMax = 5;
        Double min = 0.0;
        Double max = 1000000.0;
        Random rn = new Random();

        while(true)
        {
            try {

                String accountId = "accountId" + Integer.toString( accountIdMin + rn.nextInt(accountIdMax - accountIdMin + 1) );
                Double startingBalance = min + Math.random() * (max - min);
                String queryUrl = "http://localhost:8000/register?accountId=" + accountId +"&startingBalance=" + Double.toString(startingBalance);
                System.out.println("firing "+queryUrl);

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
