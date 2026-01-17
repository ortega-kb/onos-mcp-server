package com.ortegakb.onos_mcp_server.tool;

import com.ortegakb.onos_mcp_server.model.Host;
import com.ortegakb.onos_mcp_server.service.OnosService;
import lombok.RequiredArgsConstructor;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HostTool {

    private final OnosService onosService;

    @McpTool(name = "list-hosts", description = "Get all hosts from ONOS controller")
    public List<Host> listHosts() {
        return onosService.getAllHosts();
    }

    @McpTool(name = "get-host", description = "Get a specific host by its ID from ONOS controller")
    public Host getHost(@McpToolParam(description = "Host ID (e.g. 9A:A7:E1:2B:04:D8/None)") String id) {
        return onosService.getHostById(id);
    }

}
