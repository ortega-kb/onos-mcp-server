package com.ortegakb.onos_mcp_server.service;

import com.ortegakb.onos_mcp_server.client.OnosControllerClient;
import com.ortegakb.onos_mcp_server.model.Application;
import com.ortegakb.onos_mcp_server.model.Device;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OnosService {

    private final OnosControllerClient onosControllerClient;

    public List<Device> getAllDevices() {
        return onosControllerClient.getDevices().devices();
    }

    public Device getDeviceById(String id) {
        return onosControllerClient.getDevice(id);
    }

    public List<Application> getAllApplications() {
        return onosControllerClient.getApplications().applications();
    }

    public Application getApplicationByName(String name) {
        return onosControllerClient.getApplication(name);
    }
}
