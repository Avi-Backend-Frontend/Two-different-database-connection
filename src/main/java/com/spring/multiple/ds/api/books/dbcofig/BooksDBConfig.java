package com.spring.multiple.ds.api.books.dbcofig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "booksEntityManagerFactory", transactionManagerRef = "booksTransationManager", basePackages = {
		"com.spring.multiple.ds.api.books.repository" })
public class BooksDBConfig {

	@Value("${spring.books.datasource.url}")
	private String url;

	@Value("${spring.books.datasource.username}")
	private String username;

	@Value("${spring.books.datasource.password}")
	private String password;

	@Bean(name = "booksDBdataSource")
	public DataSource booksDBdataSource() {
		return DataSourceBuilder.create().url(url).username(username).password(password).build();

	}

	@Bean(name = "booksEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean booksEntiyManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("booksDBdataSource") DataSource booksDataSource) {
		return builder.dataSource(booksDataSource).packages("com.spring.multiple.ds.api.books.model").build();
	}

	@Bean(name = "booksTransationManager")
	public PlatformTransactionManager booksTransationManager(
			@Qualifier("booksEntityManagerFactory") EntityManagerFactory booksEntityManagerFactory) {
		return new JpaTransactionManager(booksEntityManagerFactory);
	}
	

}
