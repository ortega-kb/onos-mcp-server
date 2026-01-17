package com.ortegakb.onos_mcp_server.service;

import com.ortegakb.onos_mcp_server.client.OnosControllerClient;
import com.ortegakb.onos_mcp_server.model.Application;
import com.ortegakb.onos_mcp_server.model.Host;
import com.ortegakb.onos_mcp_server.model.Device;
import com.ortegakb.onos_mcp_server.model.Flow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OnosService {

    private final OnosControllerClient onosControllerClient;

    // Devices
    public List<Device> getAllDevices() {
        return onosControllerClient.getDevices().devices();
    }

    public Device getDeviceById(String id) {
        return onosControllerClient.getDevice(id);
    }

    // Applications
    public List<Application> getAllApplications() {
        return onosControllerClient.getApplications().applications();
    }

    public Application getApplicationByName(String name) {
        return onosControllerClient.getApplication(name);
    }

    public void activateApplication(String name) {
        onosControllerClient.activateApplication(name);
    }

    public void deactivateApplication(String name) {
        onosControllerClient.deactivateApplication(name);
    }

    // Flows
    public List<Flow> getAllFlows() {
        return onosControllerClient.getFlows().flows();
    }

    public List<Flow> getFlowsByDeviceId(String deviceId) {
        return onosControllerClient.getDeviceFlows(deviceId).flows();
    }

    public void createFlow(String deviceId, Flow flow) {
        onosControllerClient.postFlow(deviceId, flow);
    }

    // Hosts
    public List<Host> getAllHosts() {
        return onosControllerClient.getHosts().hosts();
    }

    public Host getHostById(String id) {
        return onosControllerClient.getHost(id);
    }
}
