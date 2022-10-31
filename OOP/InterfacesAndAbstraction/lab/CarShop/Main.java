package InterfacesAndAbstraction.lab.CarShop;

public class Main {
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "gray", 110, "Spain", 65_000.25);
        Rentable audi = new Audi("A8", "black", 720, "Germany", 1, 542.74);


        printCarInfo(seat);
        System.out.println(seat);

        printCarInfo(audi);
        System.out.println(audi);



        //Output:
        //Leon is gray color and have 110 horsepower
        //This is Leon produced in Spain. The price is 65000,25€
        //
        //A8 is black color and have 720 horsepower
        //This is A8 produced in Germany. The rented days are 3 and the daily price is 542,74

    }

    public static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horsepower",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
    }
}