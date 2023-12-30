package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.Email;
import tech.noetzold.dailyAPI.service.EmailReaderService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailReaderService emailReaderService;

    private static final Logger logger = LoggerFactory.getLogger(AnimeController.class);

    @GetMapping
    public ResponseEntity<List<Email>> getEmail(@RequestParam Integer count) {
        List<Email> emails = null;
        try {
            emails = emailReaderService.readInbox(count);
            logger.info("Get "+count+" emails");
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(emails);
    }
}
