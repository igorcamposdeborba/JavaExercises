package composition;

import java.util.Date;

public class HourContract {
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	public HourContract (Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}
	
	// access methods
	public Date getDate() {
		return date;
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public Integer getHours() {
		return hours;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	// logic method
	public double totalValue() {
		return hours * valuePerHour;
	}
}
