package appication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-In date (dd/MM/yyyy) ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/MM/yyyy) ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn) ) {
			System.out.println("Error in Reservation: check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation" + reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-In date (dd/MM/yyyy) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy) ");
			checkOut = sdf.parse(sc.next());
			
			//Solucao de contorno ruim
			Date now  = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for updates must be future dates. ");
				
			}
			else if(!checkOut.after(checkIn) ){
				System.out.println("Error in reservation: Reservation dates for updates must be future dates. ");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation" + reservation);
			}
			
		}
		
		sc.close();
	}

}


