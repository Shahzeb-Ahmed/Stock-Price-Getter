import java.util.ArrayList;

public class Main {

    /*
    The following is an implementation of the Stock class as of December 24, 2019 (Merry Christmas!)
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Stock> stocks= new ArrayList<Stock>();

        stocks.add(new Stock("NFLX"));   //$333.20, 0.$10 change
        stocks.add(new Stock("FB"));
        stocks.add(new Stock("TSLA"));
        stocks.add(new Stock("AAPL"));
        stocks.add(new Stock("WMT"));
        stocks.add(new Stock("XOM"));
        stocks.add(new Stock("BRKA"));
        stocks.add(new Stock("MCK"));
        stocks.add(new Stock("UNH"));
        stocks.add(new Stock("CVS"));
        stocks.add(new Stock("GM"));
        stocks.add(new Stock("F"));
        stocks.add(new Stock("T"));     //$38.96, -$0.1 change

        for(int i=0; i<stocks.size(); i++) {
            System.out.println(stocks.get(i));
        }

        System.out.println();

        stocks.get(0).compare(stocks.get(1)); // Netflix stock is worth more than Facebook
    }
}
