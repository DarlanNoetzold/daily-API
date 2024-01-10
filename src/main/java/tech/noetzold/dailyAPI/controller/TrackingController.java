package tech.noetzold.dailyAPI.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.noetzold.dailyAPI.model.TrackingResponse;
import tech.noetzold.dailyAPI.service.TrackingService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tracking")
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    private static final Logger logger = LoggerFactory.getLogger(TrackingController.class);

    @GetMapping("/package")
    public ResponseEntity<TrackingResponse> getTrendingTVShows(@RequestParam String cod) {
        TrackingResponse trendingTVShows = trackingService.getTracking(cod);
        logger.info("Get tracking package");
        return ResponseEntity.ok(trendingTVShows);
    }
}
