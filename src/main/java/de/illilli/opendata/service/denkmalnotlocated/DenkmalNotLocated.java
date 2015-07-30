package de.illilli.opendata.service.denkmalnotlocated;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse enthält zur Zeit alle übergebenen Denkmal-Dateien. Sie muss zu
 * gegebenem Zeitpunkt refactored werden.
 *
 */
public class DenkmalNotLocated {

	private static List<Denkmal> denkmalList;

	public DenkmalNotLocated() {
		if (DenkmalNotLocated.denkmalList == null) {
			DenkmalNotLocated.denkmalList = new ArrayList<Denkmal>();
		}
	}

	public void add(Denkmal denkmal) {
		if (DenkmalNotLocated.denkmalList == null) {
			DenkmalNotLocated.denkmalList = new ArrayList<Denkmal>();
		}
		if (denkmal != null && !DenkmalNotLocated.denkmalList.contains(denkmal)) {
			DenkmalNotLocated.denkmalList.add(denkmal);
		}
	}

	public DenkmalNotLocated(Denkmal denkmal) {
		this();
		add(denkmal);
	}

	public List<Denkmal> getDenkmalList() {
		return DenkmalNotLocated.denkmalList;
	}

}
