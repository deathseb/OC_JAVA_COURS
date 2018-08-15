package fr.rasen.poo.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ZoneTimeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> maps = ZoneId.SHORT_IDS;
		maps.values().stream().forEach((x) -> {System.out.println(x + " -- " + ZoneId.of(x).getRules());});

		System.out.println("");
		System.out.println("Fuseau horaire courant : "+ZoneId.systemDefault());
		System.out.println("Règle appliquer aux heures : " + ZoneId.systemDefault().getRules());


		LocalDateTime ldt = LocalDateTime.parse("2018-01-01T01:33:00");
		List<ZoneId> lzi = Arrays.asList(
				ZoneId.of("Europe/Paris"),
				ZoneId.of("Asia/Tokyo"),
				ZoneId.of("America/Anchorage")
				);	

		lzi	.stream()
		.forEach((x) -> {
			System.out.println(x + " : \t" + ldt.atZone(x).toInstant());
		});

	}

}
