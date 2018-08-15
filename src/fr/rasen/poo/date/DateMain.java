package fr.rasen.poo.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Date et heure courante : " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("Date courante : " + date1);

		Month mois = currentTime.getMonth();
		int jour = currentTime.getDayOfMonth();
		int heure = currentTime.getHour();

		System.out.println("Mois : " + mois +", jour : " + jour +", heure : " + heure);

		LocalDateTime date2 = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
		System.out.println("Date modifiée : " + date2);

		LocalDate date3 = LocalDate.of(2023, Month.DECEMBER, 25);
		System.out.println("Autre façon de faire : " + date3);

		LocalTime parsed = LocalTime.parse("20:15:30");
		System.out.println("Date parsée : " + parsed);


		LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
		System.out.println("Date de référence : " + ldt);

		System.out.println("+1 semaine : " + ldt.plus(1, ChronoUnit.WEEKS));
		System.out.println("+2 mois : " + ldt.plus(2, ChronoUnit.MONTHS));
		System.out.println("+3 ans : " + ldt.plus(3, ChronoUnit.YEARS));
		System.out.println("+4 heures : " + ldt.plus(4, ChronoUnit.HOURS));
		System.out.println("-5 secondes : " + ldt.minus(5, ChronoUnit.SECONDS));
		System.out.println("-38 minutes : " + ldt.minusMinutes(38));
	}

}
