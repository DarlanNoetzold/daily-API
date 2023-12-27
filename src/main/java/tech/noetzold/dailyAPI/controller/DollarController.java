package tech.noetzold.dailyAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.dailyAPI.model.DollarValue;
import tech.noetzold.dailyAPI.service.DollarService;

import java.util.List;

@RestController
@RequestMapping("/dollars")
public class DollarController {

    @Autowired
    DollarService dollarService;

    @GetMapping("/value")
    public ResponseEntity<DollarValue> getDollar() {
        DollarValue dollarValue = dollarService.getDolarRate();
        return ResponseEntity.ok(dollarValue);
    }
}
