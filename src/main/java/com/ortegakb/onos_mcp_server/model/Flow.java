package com.ortegakb.onos_mcp_server.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Flow(
        long groupId,
        String state,
        long life,
        String liveType,
        long lastSeen,
        long packets,
        long bytes,
        String id,
        String appId,
        int priority,
        int timeout,
        boolean isPermanent,
        String deviceId,
        int tableId,
        String tableName,
        Treatment treatment,
        Selector selector) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Treatment(
            List<Instruction> instructions,
            List<Instruction> deferred) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Instruction(
            String type,
            String port,
            String mac,
            String vlanId,
            String label,
            String tunnelId) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Selector(
            List<Criterion> criteria) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Criterion(
            String type,
            Integer port,
            String mac,
            String ethType,
            Integer ipDscp,
            Integer ipEcn,
            Integer protocol,
            String ip,
            Integer icmpType,
            Integer icmpCode,
            String tcpPort,
            String udpPort) {
    }
}
