import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        try {
            Currency_Converter currency_converter = new Currency_Converter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
class Currency_Converter{
    Currency_Converter() throws IOException {
        HashMap<Integer,String> currency = new HashMap<>();
        currency.put(1,"USD");
        currency.put(2,"EUR");
        currency.put(3,"HKD");
        currency.put(4,"INR");
        currency.put(5,"CAD");
        currency.put(6,"PKR");

        String from , To;
        double amount;
        int fromnumber , Tonumber;
        System.out.println("Welcome to Currency Converter");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter the number of currency you want to convert from");
            System.out.println("1: USD(US Dollar)\n2: EUR(Euro)\n3: HKD(Hong Kong Dollar)\n4: INR(Indian Rupees)\n5: CAD(Canadian Dollar)\n6: PKR(Pakistani Rupees)");
            fromnumber = sc.nextInt();
            if (fromnumber < 1 || fromnumber > 6) {
                System.out.println("Invalid Input");
                System.out.println("Enter Correct Option");
                System.out.println("1: USD(US Dollar)\n2: EUR(Euro)\n3: HKD(Hong Kong Dollar)\n4: INR(Indian Rupees)\n5: CAD(Canadian Dollar)\n6: PKR(Pakistani Rupees)");
                fromnumber = sc.nextInt();
            }
            from = currency.get(fromnumber);
            //System.out.println(from);
            System.out.println("Enter the number of currency you want to convert to");
            System.out.println("1: USD(US Dollar)\n2: EUR(Euro)\n3: HKD(Hong Kong Dollar)\n4: INR(Indian Rupees)\n5: CAD(Canadian Dollar)\n6: PKR(Pakistani Rupees)");
            Tonumber = sc.nextInt();
            if (Tonumber < 1 || Tonumber > 6) {

                System.out.println("Invalid Input");
                System.out.println("Enter Correct Option");
                System.out.println("1: USD(US Dollar)\n2: EUR(Euro)\n3: HKD(Hong Kong Dollar)\n4: INR(Indian Rupees)\n5: CAD(Canadian Dollar)\n6: PKR(Pakistani Rupees)");
                Tonumber = sc.nextInt();
            }
            To = currency.get(Tonumber);
            //System.out.println(To);
            System.out.println("Enter the amount you want to convert");
            amount = sc.nextDouble();
            double result = convert(from, To, amount);
            System.out.println("The amount of " + amount + " " + from + " converted " + result + " " + To);
            System.out.println("Do you want to convert again");
            System.out.println("1: Yes\n2: No");
            int choice = sc.nextInt();
            if (choice == 2) {
                break;
            }
        }while (true);
        System.out.println("Thank You for using our Currency Converter");
    }

    private double convert(String from , String to , double amount) throws IOException {
        String GET_URL = "https://api.currencyapi.com/v3/latest?apikey=cur_live_MW7iSZ7GqZF3bJ1gtvACBcm8K90qfQb43Ef6MyGW&currencies="+to+"&base_currency="+from;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String input;
            StringBuffer response = new StringBuffer();
            while((input = in.readLine()) != null){
                response.append(input);
            }
            in.close();
            JSONObject obj = new JSONObject(response.toString());
            Double rate = obj.getJSONObject("data").getJSONObject(to).getDouble("value");
            System.out.println("The Rate is "+rate);
            return  amount*rate;
        }else{
            System.out.println("GET request not worked");
        }
        return 0;
    }

}