package com.example.daggerweb;

import com.example.daggerweb.annotations.Port;

import dagger.Module;
import dagger.Provides;

@Module
public interface ServerConfigModule {

  @Provides
  @Port
  static int providePort() {
    return Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
  }
}
