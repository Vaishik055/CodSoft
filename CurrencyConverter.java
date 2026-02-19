import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

       try(Scanner sc = new Scanner(System.in)) {

        HashMap<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("INR", 83.0);
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.78);
        rates.put("JPY", 148.0);

        System.out.println("Available Currencies: USD, INR, EUR, GBP, JPY");

        System.out.print("Enter Base Currency: ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter Target Currency: ");
        String target = sc.next().toUpperCase();

        if (!rates.containsKey(base) || !rates.containsKey(target)) {
            System.out.println("Invalid currency selection.");
            sc.close();
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        double amountInUSD = amount / rates.get(base);
        double convertedAmount = amountInUSD * rates.get(target);

        System.out.println("Converted Amount: " + convertedAmount + " " + target);
       }
    }
}
