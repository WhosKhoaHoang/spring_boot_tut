package com.example.spring_boot_tut.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresDatasource {

  // . This @Bean annotation makes it so that we instantiate
  //   this HikariDataSource as a bean.
  // . The string passed to @ConfigurationProperties represents
  //   the hierarchical path specified in application.yml that
  //   will be applied to this datasource.
  // . Without these two annotations, you would get an error
  @Bean
  @ConfigurationProperties("app.datasource")
  public HikariDataSource hikariDataSource() {
    return DataSourceBuilder
           .create()
           .type(HikariDataSource.class)
           .build();
  }
}
