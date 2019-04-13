package com.acme.mailreader.utils;

import java.util.Comparator;

import com.acme.mailreader.model.Mail;

public class Comparateur {

	public Comparateur() {
		super();
	}

	public int compare(Mail obj1, Mail obj2) {
		if (obj1 == null || obj2 == null) {
			return 0;
		}
		if (compare1et2(obj1, obj2)) {
			if (obj1.isImportant() && !obj2.isImportant()) {
				return -1;
			} else {
				return 1;
			}
		}
		if (obj1.getStatut() != obj2.getStatut()) {
			int comp = obj1.getStatut().ordinal()
					- obj2.getStatut().ordinal();
			return comp > 0 ? -1 : 1;
		}
		if (obj1.getSujet() != obj2.getSujet()) {
			return obj2.getSujet().compareTo(obj1.getSujet());
		}
		return obj2.getDate().compareTo(obj1.getDate());
	}

	private boolean compare1et2(Mail obj1, Mail obj2) {
		return obj1.isImportant() != obj2.isImportant();
	}

}