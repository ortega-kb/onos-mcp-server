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

    @Tool(name = "list-applications", description = "Retrieve a list of all applications installed on the ONOS controller, showing their names, IDs, versions, and current states (e.g., ACTIVE, INSTALLED).")
    public List<Application> listApplications() {
        return onosService.getAllApplications();
    }

    @Tool(name = "get-application", description = "Retrieve detailed information about a specific ONOS application by its name. Includes description, origin, required applications, and specific features provided.")
    public Application getApplication(
            @ToolParam(description = "The unique name of the application (e.g., 'org.onosproject.fwd')") String name) {
        return onosService.getApplicationByName(name);
    }

    @Tool(name = "activate-application", description = "Activate an ONOS application by its name.")
    public void activateApplication(
            @ToolParam(description = "The unique name of the application (e.g., 'org.onosproject.fwd')") String name) {
        onosService.activateApplication(name);
    }

    @Tool(name = "deactivate-application", description = "Deactivate an ONOS application by its name.")
    public void deactivateApplication(
            @ToolParam(description = "The unique name of the application (e.g., 'org.onosproject.fwd')") String name) {
        onosService.deactivateApplication(name);
    }

}
