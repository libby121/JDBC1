package configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan({"beans","db"})
@PropertySource("classpath:app.properties")
public class SpringConfig {

	@Autowired
	private Environment env;//is autowired means the injected obj is singleton?
	
	@Bean("jbt")
	public JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource dati= new DriverManagerDataSource(env.getProperty("db.url"), env.getProperty("db.username"), env.getProperty("db.password"));
		dati.setDriverClassName(env.getProperty("db.driver"));
	return new JdbcTemplate(dati);
	}
	
	
}
