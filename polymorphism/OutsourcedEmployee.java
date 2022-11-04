public class OutsourcedEmployee extends Employee {

    private Double additionalCharge;

    public OutsourcedEmployee (String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    // Logic methods
    @Override
    public Double payment() {
         return super.payment() + additionalCharge * 1.10; // call superclass method AND add +10%
    }
}
