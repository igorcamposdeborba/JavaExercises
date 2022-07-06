package model.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation (Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) { // exception if checkout is after checkin.
			throw new DomainException("Check-out date must be after check-in date"); // this is defensive programming because is in beginning of constructor
		} 
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public Date getCheckIn () {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	// - A data de saída deve ser maior que a data de entrada
	public long duration () {
		long difference = checkOut.getTime() - checkIn.getTime(); // get dates in milliseconds
		return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS); // convert milliseconds in days
		
	}
	
	// - Alterações de reserva só podem ocorrer para datas futuras
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber 
				+ ", check-in " + sdf.format(checkIn)
				+ ", check-out " + sdf.format(checkOut)
				+ ", " + duration()
				+ " nights";
	}
}
