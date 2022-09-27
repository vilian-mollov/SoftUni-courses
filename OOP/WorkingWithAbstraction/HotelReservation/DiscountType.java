package WorkingWithAbstraction.HotelReservation;

public enum DiscountType {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    private double priceReductionFactor;

    DiscountType(double priceReductionFactor) {
        this.priceReductionFactor = priceReductionFactor;
    }

    public static DiscountType parse(String datum) {
        switch (datum) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;

            default: throw new IllegalArgumentException("Unknown enum value! " + datum);
        }

    }

    public double getPriceReductionFactor() {
        return priceReductionFactor;
    }
}
