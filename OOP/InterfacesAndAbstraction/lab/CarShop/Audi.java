package InterfacesAndAbstraction.lab.CarShop;

public class Audi extends CarImpl implements Rentable {

    private Integer minRateDay;
    private Double pricePerDay;

    public Audi(String model, String color, int horsePower, String countryProduced, Integer minRateDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        setMinRateDay(minRateDay);
        setPricePerDay(pricePerDay);
    }

    public void setMinRateDay(Integer minRateDay) {
        if (minRateDay <= 3) {
            this.minRateDay = 3;
        } else {
            this.minRateDay = minRateDay;
        }
    }

    public void setPricePerDay(Double pricePerDay) {
        if(pricePerDay < 0){
            throw new IllegalArgumentException("PricePerDay cannot be negative.");
        }
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s. The rented days are %d and the daily price is %.2f\n"
                , model, countryProduced,minRateDay,pricePerDay);
    }

    @Override
    public Integer getMinRentDay() {
        return minRateDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }
}
