package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.DollarValue;
import tech.noetzold.dailyAPI.service.DollarService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dollars")
public class DollarController {

    @Autowired
    DollarService dollarService;

    private static final Logger logger = LoggerFactory.getLogger(AnimeController.class);

    @GetMapping("/value")
    public ResponseEntity<DollarValue> getDollar() {
        DollarValue dollarValue = dollarService.getDolarRate();
        logger.info("Get dollar value - " + dollarValue.getHigh());
        return ResponseEntity.ok(dollarValue);
    }
}
