# Spring Boot WebSocket Chat Application

This is a simple real-time chat application built using **Spring Boot** and **WebSocket**. It allows users to join a chat room, send messages, and receive messages instantly, making it an ideal example for learning real-time messaging with WebSockets.

## Features
- **Real-time Messaging**: Instant message broadcasting to all connected users using WebSockets.
- **WebSocket Connection**: Utilizes Spring's WebSocket support for maintaining a live connection between clients and the server.
- **Simple UI**: Built with basic HTML, CSS, and JavaScript to demonstrate how WebSocket communication works in practice.

## Technologies Used
- **Java 17** with **Spring Boot** (latest version)
- **WebSocket** for real-time communication
- **SockJS** and **STOMP** for fallback compatibility and protocol handling
- **Thymeleaf** for rendering HTML (optional, if you want server-side templating)

## Getting Started

### Prerequisites
- **Java 17** or higher installed
- **Maven** for dependency management
- **IDE** (e.g., IntelliJ IDEA, Eclipse) or a text editor for development
- **Git** for cloning the repository

### Installation
1. **Clone the repository**:
   ```sh
   git clone https://github.com/yourusername/yourrepository.git
   cd yourrepository
Build the project using Maven:

sh
Copy code
mvn clean install
Run the Spring Boot Application:

sh
Copy code
mvn spring-boot:run
Access the Chat UI: Open your browser and go to http://localhost:8080/chat.

How to Use
Open multiple tabs in your browser to simulate different users.
Type messages in the input box and click Send.
Messages are instantly visible to all connected users, demonstrating real-time capabilities.
Project Structure
WebSocketConfig.java: Sets up the WebSocket endpoint (/chat) for clients to connect and defines how messages are broadcast.
ChatController.java: Handles incoming messages and broadcasts them to all connected clients.
chat.html: The UI for sending and receiving messages in the chat room.
static/css: Contains CSS for styling the chat interface.
Example Code Snippets
WebSocket Configuration (WebSocketConfig.java)
java
Copy code
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS();
    }
}
Chat Controller (ChatController.java)
java
Copy code
@Controller
public class ChatController {
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public String sendMessage(String message) {
        return message;
    }
}
Configuration
The WebSocket endpoint is configured at /chat.
Clients send messages to /app/sendMessage.
The server broadcasts messages to /topic/messages.
License
This project is licensed under the MIT License. Feel free to use it as a starting point for your own projects.

Contributing
Contributions are welcome! Feel free to submit a pull request or open an issue for any changes or suggestions.
