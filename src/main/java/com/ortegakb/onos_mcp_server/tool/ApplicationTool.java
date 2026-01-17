package com.ortegakb.onos_mcp_server.tool;

import com.ortegakb.onos_mcp_server.model.Application;
import com.ortegakb.onos_mcp_server.service.OnosService;
import lombok.RequiredArgsConstructor;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationTool {

    private final OnosService onosService;

    @McpTool(name = "list-applications", description = "Get all applications from ONOS controller")
    public List<Application> listApplications() {
        return onosService.getAllApplications();
    }

    @McpTool(name = "get-application", description = "Get a specific application by its name from ONOS controller")
    public Application getApplication(
            @McpToolParam(description = "Application name (e.g. org.onosproject.sdnip)") String name) {
        return onosService.getApplicationByName(name);
    }

}
