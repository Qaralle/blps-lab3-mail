package itmo.blps.lab1mail.service;

import cum.company.MailMessage;

import javax.mail.MessagingException;

public interface KafkaConsumerService {
    void listenToMessage(MailMessage msg) throws MessagingException;
}
