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

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException(
					"Error in reservation: Reservation dates for updates must be future dates. ");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// calcula a duração entre duas datas
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	// atualiza checkIn e checkOut
	public void updateDates(Date checkIn, Date checkOut) {
		// Solucao de contorno ruim
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException(
					"Error in reservation: Reservation dates for updates must be future dates. ");

		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException(
					"Error in reservation: Reservation dates for updates must be future dates. ");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", check-In: " + sdf.format(checkIn) + ", check-Out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights ";
	}
}
