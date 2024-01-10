package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.noetzold.dailyAPI.model.Email;
import tech.noetzold.dailyAPI.service.EmailReaderService;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailReaderService emailReaderService;

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @GetMapping
    public ResponseEntity<List<Email>> getEmail(@RequestParam Integer count, @RequestParam String username, @RequestParam String password) {
        List<Email> emails = null;
        try {
            emails = emailReaderService.readInbox(count, username, password);
            logger.info("Get "+count+" emails");
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(emails);
    }
}
