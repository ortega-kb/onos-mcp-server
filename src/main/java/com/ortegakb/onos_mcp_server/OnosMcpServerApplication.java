package com.ortegakb.onos_mcp_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OnosMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnosMcpServerApplication.class, args);
	}

}
