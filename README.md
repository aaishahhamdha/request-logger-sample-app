# Request Logger Sample App

A lightweight Java backend service built with [Spark Java](http://sparkjava.com/) designed for **WSO2 Identity Server** and **WSO2 Identity Gateway** documentation and testing purposes.

Identity gateway official documentation: [Protect Apps with Identity Gateway](https://is.docs.wso2.com/en/latest/references/tutorials/protect-apps-with-identity-gateway/)

![Sample Application Dark Mode](app-darkmode.png)

## Overview

The **Request Logger Sample App** is a mock backend service that captures and displays detailed information about incoming HTTP requests. It serves as a tool for:

- Testing identity gateway configurations
- Debugging proxy setups
- Demonstrating authentication flows
- Learning HTTP request structures
- Logging HTTP requests

## ✨ Features

- **Request Logging**: Captures method, endpoint, headers, cookies, and connection details
- **Modern UI**: Responsive HTML interface with beautiful styling
- **Theme Toggle**: Light/dark mode switching for better user experience
- **Real-time Display**: Shows request information as it arrives
- **Portable**: Runs as a standalone service on port 8080

## 🚀 Quick Start

### Prerequisites

- **Java**: 11 or higher
- **Maven**: 3.6 or higher
- **Git**: For cloning the repository

### Installation & Running

```bash
# Clone the repository
git clone https://github.com/wso2/samples-is.git
cd samples-is/identity-gateway/sample-request-logger-app

# Build the project
mvn clean package

# Run the application
mvn exec:java -Dexec.mainClass="org.example.RequestLogger"
```

### Alternative: Run from JAR

```bash
# Run the pre-built JAR file
java -jar target/request-logger-1.0-SNAPSSHOT-jar-with-dependencies.jar
```

## 🌐 Usage

Once the application is running:

1. **Access the app**: Navigate to `http://localhost:8080` in your browser
2. **Send requests**: Use any HTTP client (Postman, curl, browser) to send requests to the app
3. **View details**: The app will display comprehensive request information including:
   - HTTP method and endpoint
   - Request headers
   - Session cookies
   - Connection protocol details

### Example Request

```bash
curl -X POST http://localhost:8080/api/test \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer token123" \
  -d '{"message": "Hello World"}'
```

## 🏗️ Architecture

The application is built with a simple, lightweight architecture:

- **Framework**: Spark Java for HTTP handling
- **Port**: 8080 (configurable in code)
- **Response**: HTML with embedded CSS and JavaScript
- **Theme**: CSS variables for easy customization
- **Responsive**: Mobile-friendly design

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── org/example/
│   │       └── RequestLogger.java    # Main application class
│   └── resources/
├── test/
└── pom.xml                          # Maven configuration
```

## 🔧 Configuration

### Port Configuration

The default port (8080) can be modified in the `RequestLogger.java` file:

```java
public static void main(String[] args) {
    port(8080);  // Change this value as needed
    // ... rest of the code
}
```

### Build Configuration

The project uses Maven with the following key plugins:

- **maven-compiler-plugin**: Java 11 compilation
- **maven-assembly-plugin**: Creates executable JAR with dependencies

## 📦 Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| `spark-core` | 2.9.4 | HTTP framework |
| `slf4j-simple` | 1.7.36 | Logging framework |

## 🔍 Troubleshooting

### Common Issues

1. **Port Already in Use**

   ```bash
   # Check what's using port 8080
   lsof -i :8080
   
   # Kill the process or change the port in code
   ```

2. **Java Version Issues**

   ```bash
   # Verify Java version
   java -version
   
   # Should show Java 11 or higher
   ```

3. **Maven Build Failures**

   ```bash
   # Clean and rebuild
   mvn clean package -U
   ```

## 📄 License

This project is licensed under the [Apache License 2.0](LICENSE).

**Note**: This application is designed for development, testing, and demonstration purposes.
