package bg.reachup.edu.business;

public enum DiscountType {
    Economy(0.0),
    Standard(10.0),
    Business(20.0);

    private final double Discount;

    DiscountType(double discount) {    //Constructor
        this.Discount = discount;
    }

    public double getDiscount() {  //Setter
        return Discount;
    }
}
