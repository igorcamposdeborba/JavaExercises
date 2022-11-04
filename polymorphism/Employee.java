public class Employee {
    private String name;
    private Integer hours;
    private Double valuePerHour;

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    // Access methods
    public String getName() {
        return name;
    }
    public Integer getHours() {
        return hours;
    }
    public Double getValuePerHour() {
        return valuePerHour;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHours(Integer hours){
        this.hours = hours;
    }
    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    // Logic method
    public Double payment() {
        return valuePerHour * hours;
    }

}
