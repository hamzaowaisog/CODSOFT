import java.util.HashMap;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Currency_Converter currency_converter = new Currency_Converter();
    }
}
class Currency_Converter{
    Currency_Converter(){
        HashMap<Integer,String> currency = new HashMap<>();
        currency.put(1,"USD");
        currency.put(2,"EUR");
        currency.put(3,"HKD");
        currency.put(4,"INR");
        currency.put(5,"CAD");
        currency.put(6,"PKR");

        String from , To;
        double amount;
        System.out.println("Welcome to Currency Converter");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of currency you want to convert from");
        System.out.println("1:USD(US Dollar)\n2: EUR(Euro)\n3: HKD(Hong Kong Dollar)\n4: INR(Indian Rupees)\n5: CAD(Canadian Dollar)\n6: PKR(Pakistani Rupees)");
        from = currency.get(sc.nextInt());
        System.out.println(from);
    }
}