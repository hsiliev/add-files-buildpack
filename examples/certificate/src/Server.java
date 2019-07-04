import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;


public class Server {
  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(getPort()), 0);

    server.createContext("/", httpExchange -> {
      byte[] response = "Hello, World!".getBytes(StandardCharsets.UTF_8);

      httpExchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
      httpExchange.sendResponseHeaders(200, response.length);

      OutputStream out = httpExchange.getResponseBody();
      out.write(response);
      out.close();
    });

    server.start();
  }

  static int getPort() {
    String portEnv = System.getenv("PORT");
    if (portEnv == null) {
      portEnv = "8080";
    }
    return Integer.parseUnsignedInt(portEnv);
  }
}