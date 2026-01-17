package com.ortegakb.onos_mcp_server.tool;

import com.ortegakb.onos_mcp_server.model.Device;
import com.ortegakb.onos_mcp_server.service.OnosService;
import lombok.RequiredArgsConstructor;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeviceTool {

    private final OnosService onosService;

    @Tool(name = "list-devices", description = "Retrieve a comprehensive list of all network devices (switches, routers, etc.) managed by the ONOS controller, including their status, type, and hardware details.")
    public List<Device> listDevices() {
        return onosService.getAllDevices();
    }

    @Tool(name = "get-device", description = "Retrieve detailed information about a specific network device identified by its ID. Includes available status, role, manufacturer data, and software versions.")
    public Device getDevice(
            @ToolParam(description = "The unique identifier of the device (e.g., 'of:0000000000000001')") String id) {
        return onosService.getDeviceById(id);
    }
}
