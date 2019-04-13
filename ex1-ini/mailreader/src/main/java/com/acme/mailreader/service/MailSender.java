package com.acme.mailreader.service;

import com.acme.mailreader.model.Mail;

public interface MailSender {
	
	/**
	 * Envoi un mail
	 * @param mail le mail à envoyer
	 */
	void envoyerMail(Mail mail);
	

}
