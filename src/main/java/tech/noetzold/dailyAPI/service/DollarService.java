package tech.noetzold.dailyAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.DollarFeignClient;
import tech.noetzold.dailyAPI.model.dto.DollarResponse;

import java.math.BigDecimal;

@Service
public class DollarService {

    @Autowired
    private DollarFeignClient dolarFeignClient;


    public BigDecimal getDolarRate() {
        DollarResponse dolarResponse = dolarFeignClient.getDolarRate();
        return dolarResponse.getUSDBRL().getAsk();
    }
}
