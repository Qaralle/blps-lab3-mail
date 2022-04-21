package itmo.blps.lab1mail.service.impl;

import cum.company.MailMessage;
import itmo.blps.lab1mail.service.KafkaConsumerService;
import itmo.blps.lab1mail.service.MailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {
    private final MailService service;

    public KafkaConsumerServiceImpl(MailService service) {
        this.service = service;
    }

    @Override
    @KafkaListener(topics = "mail-topic", groupId = "mail-service")
    public void listenToMessage(MailMessage msg) throws MessagingException {
        System.out.println(msg.getEmail());
        service.sendMail(msg.getEmail(),msg.getText(), msg.isHTML());
    }
}
