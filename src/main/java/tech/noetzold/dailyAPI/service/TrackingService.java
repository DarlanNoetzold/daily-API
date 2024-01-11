package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.PackageFeignClient;
import tech.noetzold.dailyAPI.model.TrackingResponse;
import tech.noetzold.dailyAPI.repository.TrackingRepository;

import java.util.Date;


@Service
@Cacheable("tracking")
public class TrackingService {

    @Autowired
    private PackageFeignClient packageFeignClient;

    @Autowired
    private TrackingRepository trackingRepository;

    @Value("${spring.tracking.token}")
    private String token;

    @Value("${spring.tracking.user}")
    private String user;

    public TrackingResponse getTracking(String cod){
        TrackingResponse trackingResponse = packageFeignClient.getPackage(user, token, cod);
        trackingResponse.setRequestDate(new Date());
        trackingRepository.save(trackingResponse);

        return trackingResponse;
    }
}
