package com.acme.mailreader.presentation;

import com.acme.mailreader.commun.MailReaderModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Point d'entrée de notre client mail
 * <p>
 * Exemple d'utilisation de l'injection de dependance
 */
public class ClientMail {

	
	private static boolean production;

	public static void main(String[] args) {
		production = Boolean.parseBoolean(args[0]);
		Injector injector = Guice.createInjector(new MailReaderModule(
				production));
		InterpreteurLigneCommande cli = injector.getInstance(InterpreteurLigneCommande.class);
		cli.nouveauMail(args);
	}

	

}