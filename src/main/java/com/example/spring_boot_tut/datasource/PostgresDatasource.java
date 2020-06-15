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
  //   the hierarchical path specified in application.yml whose
  //   config values will be applied to this datasource.
  // . Without these two annotations, you would get an error.
  // . HikariDataSource is one of the best data sources to
  //   use because of how fast it is.
  @Bean
  @ConfigurationProperties("app.datasource")
  public HikariDataSource hikariDataSource() {
    return DataSourceBuilder
           .create()
           .type(HikariDataSource.class)
           .build();
  }
}
