package com.ortegakb.onos_mcp_server.client;

import com.ortegakb.onos_mcp_server.config.OnosFeignConfig;
import com.ortegakb.onos_mcp_server.model.Application;
import com.ortegakb.onos_mcp_server.model.ApplicationResponse;
import com.ortegakb.onos_mcp_server.model.HostResponse;
import com.ortegakb.onos_mcp_server.model.Device;
import com.ortegakb.onos_mcp_server.model.DeviceResponse;
import com.ortegakb.onos_mcp_server.model.Host;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/onos/v1/hosts")
    HostResponse getHosts();

    @GetMapping("/onos/v1/hosts/{id}")
    Host getHost(@PathVariable("id") String id);

    @PostMapping("/onos/v1/applications/{name}/active")
    void activateApplication(@PathVariable("name") String name);

    @DeleteMapping("/onos/v1/applications/{name}/active")
    void deactivateApplication(@PathVariable("name") String name);

}
