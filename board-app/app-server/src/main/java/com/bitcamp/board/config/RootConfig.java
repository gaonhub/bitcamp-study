package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@ComponentScan(
    value="com.bitcamp.board",
    excludeFilters = @Filter(
        type = FilterType.REGEX, 
        pattern = "com.bitcamp.board.controller.*")
    )
public class RootConfig {

  public RootConfig() {
    System.out.println("RootConfig() 생성자 호출됨!");
  }

  // @Bean 애노테이션을 붙일 때 객체 이름을 지정하면 
  // 그 이름으로 리턴 값을 컨테이너에 보관한다.
  // 이름을 지정하지 않으면 메서드 이름으로 보관한다.
  // @Bean("transactionManager")
  @Bean
  public PlatformTransactionManager transactionManager(DataSource ds) {
    return new DataSourceTransactionManager(ds);
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.mariadb.jdbc.Driver");
    ds.setUrl("jdbc:mariadb://localhost:3306/studydb");
    ds.setUsername("study");
    ds.setPassword("1111");
    return ds;
  }

}








