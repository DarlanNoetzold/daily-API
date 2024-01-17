package tech.noetzold.dailyAPI.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.DollarFeignClient;
import tech.noetzold.dailyAPI.model.DollarValue;
import tech.noetzold.dailyAPI.model.dto.DollarResponse;
import tech.noetzold.dailyAPI.repository.DollarRepository;

import java.util.Date;

@Service
@Cacheable("dollar")
public class DollarService {

    @Autowired
    private DollarFeignClient dollarFeignClient;

    @Autowired
    private DollarRepository dollarRepository;

    @Transactional
    public DollarValue getDolarRate() {
        DollarResponse dolarResponse = dollarFeignClient.getDolarRate();
        dolarResponse.getUSDBRL().setRequestDate(new Date());
        dollarRepository.save(dolarResponse.getUSDBRL());

        return dolarResponse.getUSDBRL();
    }
}
