package tech.noetzold.dailyAPI.util;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "jvmParams")     
public class JvmParamsEndpoint {

    @ReadOperation
    public Map<String, Object> jvmParameters() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        Map<String, Object> params = new HashMap<>();
        params.put("vmName", runtimeMXBean.getVmName());
        params.put("vmVendor", runtimeMXBean.getVmVendor());
        params.put("vmVersion", runtimeMXBean.getVmVersion());
        params.put("inputArguments", runtimeMXBean.getInputArguments());
        return params;
    }
}