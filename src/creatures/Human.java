package creatures;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import devices.Car;
import devices.Phone;

public class Human extends Animal
{
    String firstName;
    String lastName;
    Double salary = 3500.0;
    Double previousSalary;
    public Double cash;
    public Pet pet;
    Integer yearOfBirth;
    public Phone phone;
    private Car car;
    LocalDateTime localDate;
    DateTimeFormatter DataTimeForm = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

    public Human(String firstName, String lastName, Integer yearOfBirth, Double cash)
    {
        super("homo sapiens");
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.cash = cash;
    }
    public void displayHuman()
    {
        System.out.println("Imie: " + firstName);
        System.out.println("Nazwisko: " + lastName);
        System.out.println("Rok urodzenia: " + yearOfBirth);
    }
    public void displayPet()
    {
        if (!(pet == null))
        {
            System.out.println("Masz psa o imieniu: " + pet.name);
            System.out.println("Waży: " + pet.weight);
        }
        else {System.out.println("Nie masz zwierzaczków");}
    }
    public void displayCar()
    {
        if (!(car == null))
        {
            System.out.println("Masz samochoód: "+ car.producer + car.model + ", któy ma " + car.horsepower + " koniuw mechaniaruw");
            System.out.println("Kosztował $"+ car.value);
        }
        else {System.out.println("Nie masz samochodu");}
    }
    public void setSalary(Double salary)
    {
        if (salary < 0) {System.out.println("Nowo przypisana wypłata jest ujemna - nie można jej zmienić");}
        else
        {
            localDate = LocalDateTime.now();
            System.out.println("Dostałeś podwyżke!");
            System.out.println("Nowe dane zostały wysłane do księgowości");
            System.out.println("Aneks trafił do pani Anetki z HR'u");
            System.out.println("ZUS już wie, więc jak nas oszukasz to pójdziesz do więzienia");
            this.previousSalary = this.salary;
            this.salary = salary;
        }
    }
    public void getInformationAboutSalary()
    {
        System.out.println("Wypłata została zmieniona " + DataTimeForm.format(localDate));
        System.out.println("Poprzednia wypłata wynosiła $" + previousSalary);
        System.out.println("Obecna wypłata to $" + salary);
    }
    public void setCar(Car car)
    {
        if (salary > car.value) {System.out.println("udało ci się kupić autko za pienią$ki"); this.car = car;}
        else if (salary > car.value/12) {System.out.println("Jest autko ale jest ten kredycik"); this.car = car;}
        else {System.out.println("Nie stać cie na samochód, biedaaaku");}
    }
    public void setPurchasedCar (Car car)
    {
        if (car.isSold) {this.car = car;}
        else System.out.println("Nie możesz tego zrobic");
    }

    public void clearCar()
    {
        if (car.isSold) {this.car = null;}
        else System.out.println("Nie możesz tego zrobic");
    }

    public Car getCar () {return this.car;}
    public String toString() {return firstName + " " + lastName + " " + yearOfBirth;}

}