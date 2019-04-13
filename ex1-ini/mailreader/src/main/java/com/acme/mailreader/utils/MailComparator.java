package com.acme.mailreader.utils;

import java.util.Comparator;

import com.acme.mailreader.model.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator extends Comparateur implements Comparator<Mail> {

	public MailComparator() {
		super();
		// TODO Auto-generated constructor stub
	}

}
