package tech.noetzold.dailyAPI.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.noetzold.dailyAPI.model.TrackingResponse;

import java.util.List;

@FeignClient( value = "package", url = "https://api.linketrack.com/track")
public interface PackageFeignClient {

    @GetMapping("/json")
    TrackingResponse getPackage(@RequestParam("user") String user, @RequestParam("token") String token, @RequestParam("codigo") String codigo);

}
