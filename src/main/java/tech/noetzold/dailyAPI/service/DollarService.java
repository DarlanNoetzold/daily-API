package tech.noetzold.dailyAPI.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.DollarFeignClient;
import tech.noetzold.dailyAPI.model.DollarValue;
import tech.noetzold.dailyAPI.model.dto.DollarResponse;
import tech.noetzold.dailyAPI.repository.DollarRepository;

@Service
@Cacheable("dollar")
public class DollarService {

    @Autowired
    private DollarFeignClient dollarFeignClient;

    @Autowired
    private DollarRepository dollarRepository;


    public DollarValue getDolarRate() {
        DollarResponse dolarResponse = dollarFeignClient.getDolarRate();
        dollarRepository.save(dolarResponse.getUSDBRL());
        return dolarResponse.getUSDBRL();
    }
}
