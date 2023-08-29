package com.spring.multiple.ds.api.authors.dbcofig;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories( basePackages =  { "com.spring.multiple.ds.api.authors.repository" })
public class AuthorsDBConfig {

	@Value("${spring.authors.datasource.url}")
	private String url;

	@Value("${spring.authors.datasource.username}")
	private String username;

	@Value("${spring.authors.datasource.password}")
	private String password;

	@Primary
	@Bean
	public DataSource authorsDBdataSource() {
		return DataSourceBuilder.create().url(url).username(username).password(password).build();
	}
    
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			DataSource authorsDataSource) {
		Map<String, String> map = new HashMap<>();
		map.put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
		return builder.dataSource(authorsDataSource).packages("com.spring.multiple.ds.api.authors.model").properties(map).build();
	}
    
	@Primary
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory authorsEntityManagerFactory) {
		return new JpaTransactionManager(authorsEntityManagerFactory);
	}

}
