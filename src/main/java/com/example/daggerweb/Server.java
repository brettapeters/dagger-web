package com.example.daggerweb;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.example.daggerweb.annotations.Port;
import com.sun.net.httpserver.HttpServer;

@Singleton
public final class Server {

  private final int port;

  @Inject
  Server(@Port int port) {
    this.port = port;
  }

  public void start() throws IOException {
    HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), 0);

    httpServer.createContext("/", t -> {
      byte[] response = "Hello World!".getBytes();
      t.sendResponseHeaders(200, response.length);
      try (OutputStream os = t.getResponseBody()) {
        os.write(response);
      }
    });

    httpServer.start();

    System.out.println("started server on port " + port);
  }
}
