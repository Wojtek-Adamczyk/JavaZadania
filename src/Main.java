import creatures.FarmAnimal;
import creatures.Human;
import creatures.Pet;
import devices.Car;
import devices.CarWash;
import devices.Phone;

public class Main
{
    public static void main(String[] args)
    {
        Human me = new Human("Wojtek", "Adamczyk", 1999, 2137.0);
        me.displayHuman();

        Pet dog = new Pet("pies typu pies");
        FarmAnimal kurak = new FarmAnimal("kurak");
        kurak.setOwner(me);

        dog.name = "Piernik";
        me.pet = dog;
        dog.takeForAWalk();
        dog.feed();

        System.out.println(kurak.getOwner());
        System.out.println("Czy kurak jest posiadany? " + kurak.isOwned());

        Car car = new Car("Clio", "Renault", 1999,70, 700);
        Car car1 = new Car("Focus", "Ford", 2007,112, 19500);

        CarWash wash = new CarWash();
        wash.washTheCar(car);

        System.out.println("Porównaj 1 samochod: " + (car1 == car));
        System.out.println("Porównaj 2 samochod: " + car.equals(car1));

        me.setCar(car);
        System.out.println(me.getCar());
        me.displayCar();

        me.setSalary(4100.0);
        me.getInformationAboutSalary();

        Phone phone = new Phone("41a", "Samsung",2020,128,799);
        me.phone = phone;

        System.out.println(car);
        System.out.println(me);
        System.out.println(dog);
        System.out.println(phone);

        car.turnOn();
        phone.turnOn();

        Human buyer = new Human("Kacper", "Warda",1971,1000000.0);
        dog.sell(me, buyer, 6000.0);
        car.sell(me, buyer, 22000.0);
        phone.sell(me, buyer, 420.0);
    }
}