package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.acme.mailreader.domain.Mail;
import com.acme.mailreader.domain.Mail.Statut;
import com.acme.mailreader.domain.MailComparator;

public class MailComparatorTest {
	
	private MailComparator comparator;

	@Before
	public void setUp() throws Exception {
		this.comparator = new MailComparator();
	}

	@Test
	public final void egauxSiDeuxMailsNuls() {
		Mail mail1 = null;
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	@Test
	public final void egauxSiUnDesMailsNuls() {
		Mail mail1 = new Mail();
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	@Test
	public final void egauxSiMemeStatutNul() {
		Mail mail1 = new Mail();
		Mail mail2 = new Mail();
		mail1.setStatut(Statut.UNSENT);
		mail2.setStatut(Statut.UNSENT);
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	@Test
	public final void premierPlusGrandSiStatutEnvoie() {
		Mail mail1 = new Mail();
		Mail mail2 = new Mail();
		mail1.setStatut(Statut.SENT);
		mail2.setStatut(Statut.UNSENT);
		assertThat(comparator.compare(mail1, mail2), is(-1));
	}
	
	@Test
	public final void premierPlusGrandSiPlusImportant() {
		Mail mail1 = new Mail();
		Mail mail2 = new Mail();
		mail1.setImportant(true);
		mail2.setImportant(false);
		assertThat(comparator.compare(mail1, mail2), is(-1));
	}
	
	@Test
	public final void egauxSiMemeImportanceNulle() {
		Mail mail1 = new Mail();
		Mail mail2 = new Mail();
		mail1.setImportant(false);
		mail2.setImportant(false);
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
		
}
