package com.ortegakb.onos_mcp_server;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ortegakb.onos_mcp_server.tool.ApplicationTool;
import com.ortegakb.onos_mcp_server.tool.DeviceTool;
import com.ortegakb.onos_mcp_server.tool.FlowTool;
import com.ortegakb.onos_mcp_server.tool.HostTool;

@SpringBootApplication
@EnableFeignClients
public class OnosMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnosMcpServerApplication.class, args);
	}

	@Bean
	List<ToolCallback> onosTools(FlowTool flowTool, DeviceTool deviceTool, HostTool hostTool,
			ApplicationTool applicationTool) {
		return List.of(
				ToolCallbacks.from(deviceTool, hostTool, applicationTool, flowTool));
	}
}
