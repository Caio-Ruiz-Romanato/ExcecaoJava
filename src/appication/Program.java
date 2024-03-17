package appication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-In date (dd/MM/yyyy) ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy) ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation" + reservation);
	
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-In date (dd/MM/yyyy) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy) ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
	
			System.out.println("Reservation" + reservation);

		}
		catch(ParseException e) {
			System.out.println("Invalid date format....");
		}
		catch(DomainException e) {
			System.out.println("Erro in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Please enter numeric data only.....");
		}
		
		sc.close();
	}

}
