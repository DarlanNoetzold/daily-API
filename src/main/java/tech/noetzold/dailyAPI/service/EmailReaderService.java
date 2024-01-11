package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import jakarta.mail.*;
import tech.noetzold.dailyAPI.model.Email;
import tech.noetzold.dailyAPI.repository.EmailRepository;

import java.io.IOException;
import java.util.*;

@Service
@Cacheable("email")
public class EmailReaderService {

    @Value("${spring.mail.receive.host}")
    private String host;

    @Autowired
    private EmailRepository emailRepository;

    public List<Email> readInbox(Integer count, String username, String password) throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imaps.host", host);
        properties.put("mail.imaps.port", "993");

        Session emailSession = Session.getDefaultInstance(properties);
        Store store = emailSession.getStore("imaps");
        store.connect(host, username, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        int messageCount = inbox.getMessageCount();
        int startMessage = Math.max(1, messageCount - count);
        Message[] messages = inbox.getMessages(startMessage, messageCount);

        List<Email> emails = new ArrayList<>();

        for (Message message : messages) {
            Email email = new Email();

            email.setSubject(message.getSubject());
            email.setContent(message.getContent().toString());
            email.setSentDate(message.getSentDate());
            email.setSender(Arrays.toString(message.getFrom()));

            email.setRequestDate(new Date());
            emailRepository.save(email);
            emails.add(email);
        }

        inbox.close(false);
        store.close();

        return emails;
    }
}