package com.example.daggerweb;

public class App {

  public static void main(String[] args) throws Exception {
    Server server = ServerFactory.create().server();
    server.start();
  }
}
