package tech.noetzold.dailyAPI.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.noetzold.dailyAPI.model.DollarResponse;

@FeignClient(name = "dollar-api", url = "https://economia.awesomeapi.com.br")
public interface DollarFeignClient {

    @GetMapping("/last/USD-BRL")
    DollarResponse getDolarRate();
}