package com.ortegakb.onos_mcp_server.tool;

import com.ortegakb.onos_mcp_server.model.Flow;
import com.ortegakb.onos_mcp_server.service.OnosService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FlowTool {

    private final OnosService onosService;

    @Tool(name = "list-flows", description = "Retrieve a list of all network flows managed by the ONOS controller.")
    public List<Flow> listFlows() {
        return onosService.getAllFlows();
    }

    @Tool(name = "list-device-flows", description = "Retrieve a list of network flows for a specific device.")
    public List<Flow> listDeviceFlows(
            @ToolParam(description = "The unique identifier of the device (e.g., 'of:0000000000000001')") String deviceId) {
        return onosService.getFlowsByDeviceId(deviceId);
    }

    @Tool(name = "add-flow", description = "Add a new network flow to a specific device.")
    public void addFlow(
            @ToolParam(description = "The unique identifier of the device (e.g., 'of:0000000000000001')") String deviceId,
            @ToolParam(description = "The flow definition including priority, timeout, treatment, and selector.") Flow flow) {
        onosService.createFlow(deviceId, flow);
    }

}
