package com.ortegakb.onos_mcp_server.tool;

import com.ortegakb.onos_mcp_server.model.Host;
import com.ortegakb.onos_mcp_server.service.OnosService;
import lombok.RequiredArgsConstructor;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HostTool {

    private final OnosService onosService;

    @Tool(name = "list-hosts", description = "Retrieve a list of all end-node hosts discovered by the ONOS controller, including their MAC addresses, IP addresses, and their location in the network topology.")
    public List<Host> listHosts() {
        return onosService.getAllHosts();
    }

    @Tool(name = "get-host", description = "Retrieve detailed information about a specific end-node host by its ID. Includes its MAC address, VLAN ID, associated IP addresses, and physical locations (switch DPID and port).")
    public Host getHost(
            @ToolParam(description = "The unique identifier of the host (e.g., '00:00:00:00:00:01/None')") String id) {
        return onosService.getHostById(id);
    }

}
