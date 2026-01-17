package com.ortegakb.onos_mcp_server.tool;

import com.ortegakb.onos_mcp_server.model.Application;
import com.ortegakb.onos_mcp_server.service.OnosService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationTool {

    private final OnosService onosService;

    @Tool(name = "list-applications", description = "Get all applications from ONOS controller")
    public List<Application> listApplications() {
        return onosService.getAllApplications();
    }

    @Tool(name = "get-application", description = "Get a specific application by its name from ONOS controller")
    public Application getApplication(
            @ToolParam(description = "Application name (e.g. org.onosproject.sdnip)") String name) {
        return onosService.getApplicationByName(name);
    }

}
