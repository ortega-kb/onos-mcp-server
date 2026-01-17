package com.ortegakb.onos_mcp_server;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ortegakb.onos_mcp_server.service.OnosService;
import com.ortegakb.onos_mcp_server.tool.ApplicationTool;
import com.ortegakb.onos_mcp_server.tool.DeviceTool;
import com.ortegakb.onos_mcp_server.tool.HostTool;

@SpringBootApplication
@EnableFeignClients
public class OnosMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnosMcpServerApplication.class, args);
	}

	@Bean
	List<ToolCallback> onosTools(OnosService onosService) {
		return List.of(
				ToolCallbacks.from(
						new DeviceTool(onosService),
						new HostTool(onosService),
						new ApplicationTool(onosService)));
	}
}
