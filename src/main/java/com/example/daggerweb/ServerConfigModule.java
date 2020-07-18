package com.example.daggerweb;

import com.example.daggerweb.annotations.Port;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
interface ServerConfigModule {

  @Binds
  Server jettyServer(JettyServer server);

  @Provides
  @Port
  static int providePort() {
    return Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
  }
}
