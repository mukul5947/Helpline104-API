package com.iemr.helpline104.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.iemr.helpline104.utils.config.ConfigProperties;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", 
basePackages = { "com.iemr.helpline104.repo",
		"com.iemr.helpline104.repo", "com.iemr.helpline104.*", "com.iemr.helpline104.*" })
public class PrimaryDBConfig {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		PoolConfiguration p = new PoolProperties();
		p.setMaxActive(30);
		p.setMaxIdle(15);
		p.setMinIdle(5);
		p.setInitialSize(5);
		p.setMaxWait(10000);
		p.setMinEvictableIdleTimeMillis(15000);
		p.setRemoveAbandoned(true);
		p.setLogAbandoned(true);
		p.setRemoveAbandonedTimeout(600);
		p.setTestOnBorrow(true);
		p.setValidationQuery("SELECT 1");
		org.apache.tomcat.jdbc.pool.DataSource datasource = new org.apache.tomcat.jdbc.pool.DataSource();
		datasource.setPoolProperties(p);

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setAlgorithm("PBEWithMD5AndDES");

		encryptor.setPassword("dev-env-secret");

//		logger.info(encryptor.decrypt(ConfigProperties.getPropertyByName("encDbUserName")));
//		logger.info(encryptor.decrypt(ConfigProperties.getPropertyByName("encDbPass")));

		datasource.setUsername(encryptor.decrypt(ConfigProperties.getPropertyByName("encDbUserName")));
		datasource.setPassword(encryptor.decrypt(ConfigProperties.getPropertyByName("encDbPass")));

		return datasource;
	}


	
	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.iemr.helpline104.data", "com.iemr.helpline104.*",
				"com.iemr.helpline104.*", "com.iemr.helpline104.*").persistenceUnit("db_iemr").build();
	}

	
	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}