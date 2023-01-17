package creatures;

import devices.sellable;

public abstract class Animal implements sellable, Feedable, Ownable
{
    private static final Boolean DEFAULT_RUN = true;
    private static final Integer DEFAULT_DISTANCE = 5;
    final String species;
    public String name;
    Double weight;
    Boolean isAlive;
    Human owner;


    public Animal(String species)
    {
        isAlive = true;
        this.species = species;
        if (species.equals("pies typu pies")) {weight = 3.5;}
        else if (species.equals("chonky boi")) {weight = 14.0;}
    }

    //void feed(Double foodWeight){}

    public void feed()
    {
        if (weight > 0)
        {
            this.weight += 0.5;
            System.out.println("Piesek macha ogonem");
        }
        else System.out.println("Uśmierciłeś pieseczka i teraz nie żyje");
    }
    public void takeForAWalk() {takeForAWalk(DEFAULT_DISTANCE);}
    public void takeForAWalk(Integer distance) {this.takeForAWalk(distance, DEFAULT_RUN);}

    public void takeForAWalk(Integer distance, Boolean areWeRunning)
    {
        if (areWeRunning) {System.out.println("Pies przebiegł " + distance + " km");}

        else if (!(areWeRunning)) {System.out.println("Pies przeszedł " + distance + "km");}

        if (isAlive && (weight > 0))
        {
            this.weight -= 0.5;
            System.out.println("Pieseczek cieszy się spacerkiem");

            if (weight < 0) {isAlive = false;}
        }
        else System.out.println("Chodzenie z martwym psem na smyczy jest lekko... dziwne");
    }
    public void feed(Integer foodWeight)
    {
        if (weight > 0)
        {
            this.weight += foodWeight;
            System.out.println("Piesek macha ogonem");
        }
        else System.out.println("Uśmierciłeś pieseczka i teraz nie żyje");

        System.out.println("feed(Integer)");
    }
    public String toString() {return species + ", " + name + ", " + weight + "kg, a żyje? " + isAlive;}

    @Override
    public void sell(Human seller, Human buyer, Double price)
    {
        if (seller.pet != null)
        {
            if (buyer.cash >= price)
            {
                seller.cash += price;
                buyer.cash -= price;
                buyer.pet = seller.pet;
                seller.pet = null;
                System.out.println("SPRZEDANO ZWIERZACZKA :(");
            }
            else System.out.println("Kupujący nie ma kaski");
        }
        else System.out.println("Nie ma nic na sprzedaż");
    }

    @Override
    public Human getOwner() {return this.owner;}

    public void setOwner(Human human){this.owner = human;}

    @Override
    public Boolean isOwned() {return this.owner != null;}
}