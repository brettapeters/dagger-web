package com.example.daggerweb;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.example.daggerweb.annotations.Port;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

@Singleton
final class JettyServer implements com.example.daggerweb.Server {

  private final int port;

  @Inject
  JettyServer(@Port int port) {
    this.port = port;
  }

  public void start() throws Exception {
    Server server = new Server(port);

    // Configure
    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    server.setHandler(new HelloHandler());

    // Start the server
    server.start();
    server.dumpStdErr();
    server.join();
  }
}
