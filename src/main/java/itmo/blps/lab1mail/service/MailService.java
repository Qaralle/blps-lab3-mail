package itmo.blps.lab1mail.service;

import javax.mail.MessagingException;

public interface MailService {
    void sendMail(String email, String text, boolean isHTML) throws MessagingException;
}
