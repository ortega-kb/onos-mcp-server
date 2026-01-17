package com.ortegakb.onos_mcp_server.model;

public record Annotations(
        String channelId,
        String datapathDescription,
        String managementAddress,
        String protocol) {
}
