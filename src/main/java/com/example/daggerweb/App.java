package com.example.daggerweb;

import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    System.out.println("hello!!!");
    Server server = ServerFactory.create().server();
    server.start();
  }
}
