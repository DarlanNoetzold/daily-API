package tech.noetzold.dailyAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.DollarFeignClient;
import tech.noetzold.dailyAPI.model.DollarValue;
import tech.noetzold.dailyAPI.model.dto.DollarResponse;
import tech.noetzold.dailyAPI.repository.DollarRepository;

import java.math.BigDecimal;

@Service
public class DollarService {

    @Autowired
    private DollarFeignClient dolarFeignClient;

    @Autowired
    private DollarRepository dollarRepository;


    public DollarValue getDolarRate() {
        DollarResponse dolarResponse = dolarFeignClient.getDolarRate();
        return dollarRepository.save(dolarResponse.getUSDBRL());
    }
}
