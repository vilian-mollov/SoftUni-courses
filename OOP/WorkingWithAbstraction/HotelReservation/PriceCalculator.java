package WorkingWithAbstraction.HotelReservation;

public class PriceCalculator {

    double pricePerDay;
    int days;
    Season season;
    DiscountType discountType;

    public PriceCalculator(double pricePerDay, int days, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discountType = discountType;
    }

    public double getTotalPrice() {
        return this.pricePerDay * this.days * season.getMultiplier() * discountType.getPriceReductionFactor();
    }


}
