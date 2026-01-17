package com.ortegakb.onos_mcp_server.model;

public record Device(
        String id,
        String type,
        boolean available,
        String role,
        String mfr,
        String hw,
        String sw,
        String serial,
        String driver,
        String chassisId,
        String lastUpdate,
        String humanReadableLastUpdate,
        Annotations annotations) {
}
