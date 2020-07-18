package com.example.daggerweb;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ServerConfigModule.class })
interface ServerFactory {

  Server server();

  static ServerFactory create() {
    return DaggerServerFactory.create();
  }
}
