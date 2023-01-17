package devices;

import creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Phone extends Device implements sellable
{
    private static final String DEFAULT_ADDRESS = "abcdef";
    private static final Double DEFAULT_VERSION = 122.0;
    private static final String DEFAULT_PROTOCOL = "https";
    public Integer memory;

    public Phone(String model, String producer,Integer yearOfProduction, Integer memory, Integer value)
    {
        super(producer, model, yearOfProduction, value);
        this.memory = memory;
    }

    public String toString(){return model + ", " + producer + ", $" + value + ", " + memory;}

    @Override
    public void turnOn() {System.out.println("Telefon jest włączony");}

    @Override
    public void sell(Human seller, Human buyer, Double price)
    {
        if (seller.phone != null)
        {
            if (buyer.cash >= price)
            {
                seller.cash += price;
                buyer.cash -= price;
                buyer.phone = seller.phone;
                seller.phone = null;
                System.out.println("SPRZEDANO TELEFON");
            }
            else System.out.println("Kupujący nie ma kaski");
        }
        else System.out.println("Nie ma nic na sprzedaż");
    }

    void installAnnApp(String name) {this.installAnnApp(name, DEFAULT_VERSION);}

    void installAnnApp(String name, Double version) {this.installAnnApp(name, version, DEFAULT_ADDRESS);}

    void installAnnApp(String name, Double version, String address)
    {
        try
        {
            URL url = new URL(DEFAULT_PROTOCOL, address, name + "-" + version);
            this.installAnnApp(url);
        }
        catch (MalformedURLException e) {throw new RuntimeException(e);}

        System.out.println("Zakończono");
    }
    void installAnnApp(List<String> list) {for (String name : list) {this.installAnnApp(name);}}

    void installAnnApp(URL url) {System.out.println("Pobrano aplikacje z adresu URL");}
}