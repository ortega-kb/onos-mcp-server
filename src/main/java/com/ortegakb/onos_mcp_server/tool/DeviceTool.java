package com.ortegakb.onos_mcp_server.tool;

import com.ortegakb.onos_mcp_server.model.Device;
import com.ortegakb.onos_mcp_server.service.OnosService;
import lombok.RequiredArgsConstructor;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeviceTool {

    private final OnosService onosService;

    @McpTool(name = "list-devices", description = "Get all devices from ONOS controller")
    public List<Device> listDevices() {
        return onosService.getAllDevices();
    }

    @McpTool(name = "get-device", description = "Get a specific device by its ID from ONOS controller")
    public Device getDevice(@McpToolParam(description = "Device ID") String id) {
        return onosService.getDeviceById(id);
    }
}
