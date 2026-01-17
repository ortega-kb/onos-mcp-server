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

    @Tool(name = "list-devices", description = "Get all devices from ONOS controller")
    public List<Device> listDevices() {
        return onosService.getAllDevices();
    }

    @Tool(name = "get-device", description = "Get a specific device by its ID from ONOS controller")
    public Device getDevice(@ToolParam(description = "Device ID") String id) {
        return onosService.getDeviceById(id);
    }
}
