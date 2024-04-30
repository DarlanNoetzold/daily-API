package tech.noetzold.dailyAPI.util;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.lang.management.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Endpoint(id = "jvmDetails")
public class JvmParamsEndpoint {

    @ReadOperation
    public Map<String, Object> jvmDetails() {
        Map<String, Object> details = new HashMap<>();

        // Runtime Information
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        details.put("inputArguments", runtimeMXBean.getInputArguments());

        // Memory Information
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        details.put("heapMemoryInit", heapMemoryUsage.getInit());
        details.put("heapMemoryUsed", heapMemoryUsage.getUsed());
        details.put("heapMemoryCommitted", heapMemoryUsage.getCommitted());
        details.put("heapMemoryMax", heapMemoryUsage.getMax());

        // Garbage Collector Information
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        List<Map<String, Object>> gcDetailsList = new ArrayList<>();
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            Map<String, Object> gcDetails = new HashMap<>();
            gcDetails.put("name", gcBean.getName());
            gcDetails.put("collectionCount", gcBean.getCollectionCount());
            gcDetails.put("collectionTime", gcBean.getCollectionTime());
            gcDetailsList.add(gcDetails);
        }
        details.put("garbageCollectors", gcDetailsList.get(0).get("name"));

        return details;
    }
}