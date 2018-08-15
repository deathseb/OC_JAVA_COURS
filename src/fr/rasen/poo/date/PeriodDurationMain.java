package fr.rasen.poo.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDurationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
		LocalDateTime ldt2 = ldt.plus(3, ChronoUnit.YEARS);
		LocalDateTime ldt3 = ldt.minusMinutes(1337);

		Period p = Period.between(ldt.toLocalDate(), ldt2.toLocalDate());
		Duration d = Duration.between(ldt.toLocalTime(), ldt3.toLocalTime());
		System.out.println("Période : " + p);
		System.out.println("Durée : " + d.getSeconds());
		System.out.println("Ecart en jour : " + ChronoUnit.DAYS.between(ldt, ldt2));
	}

}
