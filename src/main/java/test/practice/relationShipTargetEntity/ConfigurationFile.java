package test.practice.relationShipTargetEntity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

//@Configuration
//@ComponentScan("test.practice.relationShipTargetEntity")
public class ConfigurationFile {
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"); //jdbc:h2:~/myDB;DB_CLOSE_DELAY=-1");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");

	    // schema init
	    //Tested in Case of Both schema and insert operation
	    Resource initSchema = new ClassPathResource("scripts/schema-h2.sql");
	    Resource initData = new ClassPathResource("scripts/targetEntityTest2.sql");
	    DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
	   
	    DatabasePopulatorUtils.execute(databasePopulator, dataSource); 

	    return dataSource;
	}

}
