package com.ortegakb.onos_mcp_server.model;

import java.util.List;

public record Host(
        String id,
        String mac,
        String vlan,
        String innerVlan,
        String outerTpid,
        boolean configured,
        boolean suspended,
        List<String> ipAddresses,
        List<Location> locations) {
}
