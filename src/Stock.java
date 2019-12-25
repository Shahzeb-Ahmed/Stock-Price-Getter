import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Stock {
    private final String _ticker;
    private String _price;
    private String _change;

    Stock(String ticker) {
        this._ticker = ticker.toUpperCase();
        this._price = "0.00";
        this._change = "0.00";
    }

    @Override
    public String toString() {
        try {
            this.priceAndChange();
        } catch (Exception e) {
            return "Exception caused due to " + this._ticker;
        }
        if(this._change.contains("-")) {
            return this._ticker + " is currently priced at $" + this._price + " and changed by -$" + this._change.subSequence(1, this._change.length()) + ".";
        }
        return this._ticker + " is currently priced at $" + this._price + " and changed by $" + this._change + ".";
    }

    /*
    Get most recent price and price change of stock
     */
    public void priceAndChange() throws Exception {
        try {
            URL url = new URL("https://www.marketwatch.com/investing/stock/" + this._ticker);
            URLConnection urlConnection = url.openConnection();
            InputStreamReader stream = new InputStreamReader(urlConnection.getInputStream());

            BufferedReader br = new BufferedReader(stream);
            for(int i = 0; i<45; i++) {
                br.readLine();
            }
            String line1 = br.readLine();
            String priceString = line1.substring(44,line1.indexOf("\">"));
            this._price = priceString;

            String line2 = br.readLine();
            String priceChangeString = line2.substring(50,line2.indexOf("\">"));
            this._change = priceChangeString;
        }
        catch(Exception e) {
            System.out.println("Exception caused by " + this._ticker);
        }
    }

    /*
    Compare two stocks based on price. If the price is equal, compare change in price.
     */
    public void compare(Stock a) throws Exception {
        this.priceAndChange();
        a.priceAndChange();
        if(Double.parseDouble(a._price)==Double.parseDouble(this._price)) {
            System.out.println("Both stocks are currently worth the same.");
            if(Double.parseDouble(a._change)==Double.parseDouble(this._change))
                System.out.print(" Their price change are also the same.");
            else if(Double.parseDouble(a._change)>Double.parseDouble(this._change))
                System.out.print(" " + a._ticker + " stock is worth more based on price change.");
            else
                System.out.print(" " + this._ticker + " stock is worth more based on price change.");
        }
        else if(Double.parseDouble(a._price)>Double.parseDouble(this._price))
            System.out.println(a._ticker + " stock is worth more.");
        else
            System.out.println(this._ticker + " stock is worth more.");
    }
}
