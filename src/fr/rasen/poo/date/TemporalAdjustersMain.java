package fr.rasen.poo.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate ldt = LocalDate.of(2018, Month.DECEMBER, 25);

		LocalDate prochainSamedi = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println(prochainSamedi);

		ldt = ldt.plus(1, ChronoUnit.MONTHS);

		LocalDate ldt2 = LocalDate.of(ldt.getYear(), ldt.getMonth(), 1);

		LocalDate troisiemeMardi = ldt2	.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
				.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
				.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println(troisiemeMardi);
	}

}
