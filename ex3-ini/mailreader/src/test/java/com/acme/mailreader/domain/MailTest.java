package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;

import org.junit.Test;

import com.acme.mailreader.domain.Mail.Statut;

public class MailTest {
	
	MailComparator comparator = new MailComparator();
	

	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateAvant1970() throws DateIncorrecteException {
		new Mail.Builder("sujet").date(Instant.parse("1950-01-01T10:23:10.00Z")).build();
	}
	
	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateApres2100() throws DateIncorrecteException{
		new Mail.Builder("sujet").date(Instant.parse("2102-01-01T10:23:10.00Z")).build();
	}
	
	@Test
	public final void premierPlusPetitSiDateNulle() throws DateIncorrecteException  {
		Mail mail1 = new Mail.Builder("sujet").important(false).statut(Statut.READ).build();
		Mail mail2 = new Mail.Builder("sujet").important(false).statut(Statut.READ).date(Instant.now()).build();
		assertThat(comparator.compare(mail1, mail2),is(1));
	}

	
	@Test
	public final void premierPlusGrandSiDateNulle() throws DateIncorrecteException {
		Mail mail1 = new Mail.Builder("sujet").important(true).statut(Statut.READ).date(Instant.now()).build();
		Mail mail2 = new Mail.Builder("sujet").important(true).statut(Statut.READ).build();
		assertThat(comparator.compare(mail1, mail2),is(-1));
	}
	
	//peut-etre un truc avec le tri.
}
