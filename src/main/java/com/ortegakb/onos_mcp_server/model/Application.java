package com.ortegakb.onos_mcp_server.model;

import java.util.List;

public record Application(
        String name,
        int id,
        String version,
        String category,
        String description,
        String readme,
        String origin,
        String url,
        String featuresRepo,
        String state,
        List<String> features,
        List<String> permissions,
        List<String> requiredApps) {
}
