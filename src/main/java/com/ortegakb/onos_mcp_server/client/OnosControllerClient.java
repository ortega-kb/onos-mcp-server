package com.ortegakb.onos_mcp_server.client;

import com.ortegakb.onos_mcp_server.config.OnosFeignConfig;
import com.ortegakb.onos_mcp_server.model.Application;
import com.ortegakb.onos_mcp_server.model.ApplicationResponse;
import com.ortegakb.onos_mcp_server.model.Device;
import com.ortegakb.onos_mcp_server.model.DeviceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "onosControllerClient", url = "${onos.controller.host}", configuration = OnosFeignConfig.class)
public interface OnosControllerClient {

    @GetMapping("/onos/v1/devices")
    DeviceResponse getDevices();

    @GetMapping("/onos/v1/devices/{id}")
    Device getDevice(@PathVariable("id") String id);

    @GetMapping("/onos/v1/applications")
    ApplicationResponse getApplications();

    @GetMapping("/onos/v1/applications/{name}")
    Application getApplication(@PathVariable("name") String name);

}
