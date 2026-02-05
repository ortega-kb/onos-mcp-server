# ONOS MCP Server 🚀

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.9-brightgreen)](https://spring.io/projects/spring-boot)
[![Java 21](https://img.shields.io/badge/Java-21-blue)](https://www.oracle.com/java/technologies/downloads/#java21)
[![MCP](https://img.shields.io/badge/MCP-Model%20Context%20Protocol-orange)](https://modelcontextprotocol.io/)

**ONOS MCP Server** is a powerful bridge between the **Model Context Protocol (MCP)** and the **Open Network Operating System (ONOS)**. It enables AI models to interact directly with your SDN (Software-Defined Networking) infrastructure, allowing for intelligent network management, monitoring, and automation.

---

## ✨ Features

- 📱 **Application Management**: List, inspect, activate, and deactivate ONOS applications.
- 🔌 **Device Inventory**: Detailed views of switches, routers, and other network entities.
- 🏠 **Host Discovery**: Track end-nodes, their locations, and IP/MAC associations.
- 🌊 **Flow Control**: Full visibility and control over network flows (list, filter by device, and add new flows).
- 🛠️ **Seamless Integration**: Built with Spring Boot and Spring AI MCP for robust, production-ready performance.

---

## 📋 Prerequisites

- **Java 21** or higher.
- **Maven 3.9+** (or use the included `./mvnw`).
- A running instance of **ONOS Controller** (v2.x or higher recommended).

---

## ⚙️ Configuration

The server connects to ONOS via its REST API. You can configure the connection details in `src/main/resources/application.yaml` or via environment variables.

```yaml
onos:
    controller:
        host: ${ONOS_CONTROLLER_HOST:http://localhost:8181}
        username: ${ONOS_CONTROLLER_USERNAME:onos}
        password: ${ONOS_CONTROLLER_PASSWORD:rocks}
```

### Environment Variables
| Variable | Description | Default |
|----------|-------------|---------|
| `ONOS_CONTROLLER_HOST` | URL of the ONOS controller | `http://localhost:8181` |
| `ONOS_CONTROLLER_USERNAME` | ONOS user (requires REST access) | `onos` |
| `ONOS_CONTROLLER_PASSWORD` | ONOS password | `rocks` |

---

## 🚀 Getting Started

### 1. Build the project
```bash
./mvnw clean install
```

### 2. Run the server
```bash
./mvnw spring-boot:run
```

---

## 🔌 Connecting to MCP Clients

To use this server with an MCP client (such as **Claude Desktop** or **Antigravity**), add the following configuration to your `mcp_config.json` (or equivalent configuration file):

```json
{
  "mcpServers": {
    "onos-mcp-server": {
      "command": "java",
      "args": [
        "-jar",
        "/path/to/onos-mcp-server.jar"
      ],
      "env": {
        "ONOS_CONTROLLER_HOST": "http://localhost:8181",
        "ONOS_CONTROLLER_USERNAME": "onos",
        "ONOS_CONTROLLER_PASSWORD": "rocks"
      }
    }
  }
}
```

> [!NOTE]
> Make sure to build the project first with `./mvnw clean install` to generate the JAR file in the `target/` directory.

---

## 🛠️ Available MCP Tools

The server exposes several tools to the AI model:

### Applications
- `list-applications`: List all installed applications and their status.
- `get-application`: Get details about a specific application.
- `activate-application`: Activate a specific application by name.
- `deactivate-application`: Deactivate a specific application.

### Devices
- `list-devices`: Get a list of all devices (switches, routers).
- `get-device`: Get detailed info on a specific device.

### Hosts
- `list-hosts`: List all discovered end-node hosts.
- `get-host`: Get details on a specific host.

### Flows
- `list-flows`: List all network flows.
- `list-device-flows`: List flows for a specific device.
- `add-flow`: Push a new flow rule to a device.

---

## 🏗️ Tech Stack

- **Core**: Java 21, Spring Boot 3.5.9
- **AI/MCP**: Spring AI Starter MCP Server
- **REST Client**: Spring Cloud OpenFeign
- **Utilities**: Lombok

---

Created with ❤️ by [ortegakb](https://github.com/ortegakb)
