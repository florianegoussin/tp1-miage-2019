package com.acme.mailreader.presentation;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.acme.mailreader.model.Mail;
import com.acme.mailreader.service.MailService;
import com.google.inject.Inject;

public class InterpreteurLigneCommande {
	
	//TODO : injecter un serviceMail par constructeur
	private MailService serviceMail;
	
	
	public InterpreteurLigneCommande() {
		super();
	}
	
	@Inject
	//Injecté par constructeur
	public InterpreteurLigneCommande(MailService serviceMail) {
		super();
		this.serviceMail = serviceMail;
	}

	/**
	 * Parse les arguments de la ligne de commande
	 * @param args tableau d'arguments
	 */
	public void nouveauMail(String[] args){
		String sujet = args[1];
		Mail mail = new Mail.Builder(sujet).build();
		//TODO
	}
}